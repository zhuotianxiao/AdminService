package cn.fundview.modules.web.account;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.KyOrg;
import cn.fundview.modules.service.KyOrgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/${adminPath}/account/kyorg")
public class KyOrgController extends BaseController{

	// Service
	@Resource(name = "kyOrgService")
	private KyOrgService kyOrgService;

	@RequestMapping(value="/index")
	public String list(Model model) {
		List<KyOrg> list = kyOrgService.findList(new KyOrg());
		model.addAttribute("list", list);
		return "modules/account/kyorg/index";
	}
	
	/**
	 * 禁用/启用科研机构
	 * 
	 * @param id
	 * @param flag
	 * @param model
	 * @return String
	 *
	 */
	@RequestMapping(value="/valid/{id}/{flag}")
	public String valid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		kyOrgService.validKyorg(id, flag);
		return "redirect:" + adminPath + "/account/kyorg/index";
	}
	
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")String id,Model model) {
		
		KyOrg kyOrg = new KyOrg();
		kyOrg.setId(id);
		kyOrg = kyOrgService.get(kyOrg);
		model.addAttribute("kyOrg", kyOrg);
		return "modules/account/kyorg/info";
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
	public String toAuth(@PathVariable(value="id")String id,Model model) {
		
		KyOrg kyOrg = new KyOrg();
		kyOrg.setId(id);
		kyOrg = kyOrgService.get(id);
		model.addAttribute("kyOrg", kyOrg);
		return "modules/account/kyorg/auth";
	}
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String auth(KyOrg kyorg) {
		
		kyOrgService.updateKyOrg(kyorg);
		return "redirect:" + adminPath + "/account/kyorg/index";
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
	public String toSetting(@PathVariable("id") String id, Model model){
		KyOrg kyOrg = new KyOrg();
		kyOrg.setId(id);
		kyOrg = kyOrgService.get(id);
		model.addAttribute("kyOrg", kyOrg);
		return "modules/account/kyorg/setting";
	}
	@RequestMapping(value="/setting",method=RequestMethod.POST)
	public String setting(KyOrg kyOrg){
		kyOrgService.updateKyOrg(kyOrg);
		return "redirect:" + adminPath + "/account/kyorg/index";  
	}
}
