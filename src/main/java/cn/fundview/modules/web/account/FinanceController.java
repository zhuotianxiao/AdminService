package cn.fundview.modules.web.account;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.service.FinanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/${adminPath}/account/finance")
public class FinanceController extends BaseController{

	// Service
	@Resource(name = "financeService")
	private FinanceService service;

	@RequestMapping(value="/index")
	public String list(Model model) {
		List<Finance> list = service.findList(new Finance());
		model.addAttribute("list", list);
		return "modules/account/finance/index";
	}
	
	/**
	 * 禁用/启用金融机构
	 * 
	 * @param id
	 * @param flag
	 * @return String
	 *
	 */
	@RequestMapping(value="/valid/{id}/{flag}")
	public String valid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		service.validFinance(id, flag);
		return "redirect:" + adminPath + "/account/finance/index";
	}

    /**
     * 查看详细
     * @param id 金融机构id
     * @param model
     * @return
     */
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")String id,Model model) {
		
		Finance finance = new Finance();
		finance.setId(id);
		finance = service.get(finance);
		model.addAttribute("finance", finance);
		return "modules/account/finance/info";
	}

}
