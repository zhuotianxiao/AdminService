package cn.fundview.modules.web.techrequ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.TechRequ;
import cn.fundview.modules.service.TechService;


/**
 * 需求综合管理
 * Controller
 * @author wangjian
 * @version 2013-5-31
 */
@Controller
@RequestMapping("${adminPath}/techrequ/techrequ")
public class TechrequController extends BaseController{
	
	@Autowired
	private TechService techService;
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
        model.addAttribute("list", techService.findAll());
		return "modules/techrequ/techrequ/index";
	}
	
	/**
	 * 禁用/启用成果
	 * 
	 * @param id
	 * @param flag
	 * @param model
	 * @return String
	 *
	 */
	@RequestMapping(value="/valid/{id}/{flag}")
	public String valid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		techService.validTech(id, flag);
		return "redirect:" + adminPath + "/techrequ/techrequ/index";
	}
	/**
	 * 查看详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")String id,Model model) {
		TechRequ techrequ = new TechRequ();
		techrequ.setId(id+"");
		techrequ = techService.get(techrequ);
		//System.out.println(achvNew.getCreateDate());
		model.addAttribute("techrequ", techrequ);
		return "modules/techrequ/techrequ/info";
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
		TechRequ techrequ = new TechRequ();
		techrequ.setId(id+"");
		techrequ = techService.get(techrequ);
		model.addAttribute("techrequ", techrequ);
		return "modules/techrequ/techrequ/setting";
	}
	/**
	 * 提交前台展示设置
	 * @param expert
	 * @return
	 */
	@RequestMapping(value="/setting",method=RequestMethod.POST)
	public String setting(TechRequ techrequ){
		techService.updateTech(techrequ);
		return "redirect:" + adminPath + "/techrequ/techrequ/index";   
	}
	
	
}
