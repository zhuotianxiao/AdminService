package cn.fundview.modules.web.account;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.model.Gov;
import cn.fundview.modules.service.FinanceService;
import cn.fundview.modules.service.GovService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 政府机构controller
 */
@Controller
@RequestMapping(value="/${adminPath}/account/gov")
public class GovController extends BaseController{

	// Service
	@Resource(name = "govService")
	private GovService service;

	@RequestMapping(value="/index")
	public String list(Model model) {
		List<Gov> list = service.getList();
		model.addAttribute("list", list);
		return "modules/account/gov/index";
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
		
		service.validGov(id, flag);
		return "redirect:" + adminPath + "/account/gov/index";
	}

    /**
     * 查看详细
     * @param id 金融机构id
     * @param model
     * @return
     */
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")int id,Model model) {
		
		Gov gov = new Gov();
		gov.setAccountId(id);
		gov = service.get(gov);
		model.addAttribute("gov", gov);
		return "modules/account/gov/info";
	}

}
