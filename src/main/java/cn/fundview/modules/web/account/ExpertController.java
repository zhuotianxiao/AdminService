package cn.fundview.modules.web.account;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Expert;
import cn.fundview.modules.service.AccountService;
import cn.fundview.modules.service.ExpertService;
import cn.fundview.modules.service.TcDictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/${adminPath}/account/expert")
public class ExpertController extends BaseController{

	//Service
	@Resource(name = "expertService")
	private ExpertService expertService;
	
	//Service
	@Resource(name = "accountService")
	private AccountService accountService;
	//Service
	@Resource(name = "tcDictService")
	private TcDictService dictService;


	@RequestMapping(value="/index")
	public String list(Model model) {

		List<Expert> list = expertService.listAll();
		model.addAttribute("list", list);
		return "modules/account/expert/index";
	}
	
	/**
	 * 禁用/启用专家
	 * 
	 * @param id
	 * @param flag
	 * @return String
	 *
	 */
	@RequestMapping(value="/valid/{id}/{flag}")
	public String valid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		expertService.validExpert(id, flag);
		return "redirect:" + adminPath + "/account/expert/index";
	}
	
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")String id,Model model) {
		
		Expert expert = new Expert();
		expert.setId(id+"");
		expert = expertService.get(expert);
		System.out.println(expert.getCreateDate());
		model.addAttribute("expert", expert);
//		Account param = new Account();
//		param.setId(id);
//		model.addAttribute("account", accountService.get(param));
		return "modules/account/expert/info";
	}
	
	/**
	 * 修改认证信息
	 * 
	 * @param id
	 * @param model
	 * @return String
	 *
	 */
	@RequestMapping(value="/auth/{id}",method=RequestMethod.GET)
	public String toAuth(@PathVariable(value="id")int id,Model model) {
		
		Expert expert = new Expert();
		expert.setId(id+"");
		expert = expertService.get(id+"");
		model.addAttribute("expert", expert);
		return "modules/account/expert/auth";
	}
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String auth(Expert expert) {
		
		expertService.updateExpert(expert);
		return "redirect:" + adminPath + "/account/expert/index";
	}
	
	/**
	 * 设置专家的前台展示
	 * 
	 * @param id
	 * @param model
	 * @return String
	 *
	 */
	@RequestMapping(value="/setting/{id}",method=RequestMethod.GET)
	public String toSetting(@PathVariable("id") int id, Model model){
		Expert expert = new Expert();
		expert.setId(id+"");
		expert = expertService.get(id+"");
		model.addAttribute("expert", expert);
		return "modules/account/expert/setting";
	}
	@RequestMapping(value="/setting",method=RequestMethod.POST)
	public String setting(Expert expert){
		expertService.updateExpert(expert);
		return "redirect:" + adminPath + "/account/expert/index";   
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public String statistics(Model model) {

		model.addAttribute("list", expertService.countAllExpertByArea());
		return "modules/account/expert/statistics";
	}
}
