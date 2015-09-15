/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.modules.web.achv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.AchvNew;
import cn.fundview.modules.service.AchvService;


/**
 * 成果综合管理
 * Controller
 * @author wangjian
 * @version 2013-5-31
 */
@Controller
@RequestMapping("${adminPath}/achv/join")
public class JoinController extends BaseController{
	
	@Autowired
	private AchvService achvService;
	
	@RequestMapping(value = "/no")
	public String no(Model model) {
        model.addAttribute("list", achvService.findNo());
		return "modules/achv/join/no";
	}
	@RequestMapping(value = "/now")
	public String now(Model model) {
        model.addAttribute("list", achvService.findNow());
		return "modules/achv/join/now";
	}
	@RequestMapping(value = "/end")
	public String end(Model model) {
        model.addAttribute("list", achvService.findEnd());
		return "modules/achv/join/end";
	}
	
	/**
	 * 查看详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/info/{id}")
	public String info(@PathVariable(value="id")String id,Model model) {
		AchvNew achvNew = new AchvNew();
		achvNew.setId(id+"");
		achvNew = achvService.get(achvNew);
		System.out.println(achvNew.getCreateDate());
		model.addAttribute("achvNew", achvNew);
		return "modules/achv/join/info";
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
	@RequestMapping(value="/no/valid/{id}/{flag}")
	public String noValid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		achvService.validAchv(id, flag);
		return "redirect:" + adminPath + "/achv/join/no";
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
	@RequestMapping(value="/now/valid/{id}/{flag}")
	public String nowValid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		achvService.validAchv(id, flag);
		return "redirect:" + adminPath + "/achv/join/now";
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
	@RequestMapping(value="/end/valid/{id}/{flag}")
	public String endValid(@PathVariable(value="id")String id, @PathVariable(value="flag")boolean flag) {
		
		achvService.validAchv(id, flag);
		return "redirect:" + adminPath + "/achv/join/end";
	}
	/**
	 * 设置专家的前台展示
	 * 
	 * @param id
	 * @param model
	 * @return String
	 *
	 */
	@RequestMapping(value="/setting/{mark}/{id}",method=RequestMethod.GET)
	public String toSetting(@PathVariable("id") int id,@PathVariable("mark") String mark, Model model){
		AchvNew achvNew = new AchvNew();
		achvNew.setId(id+"");
		achvNew = achvService.get(achvNew);
		model.addAttribute("achvNew", achvNew);
		return "modules/achv/join/"+mark+"-setting";
	}
	/**
	 * 提交前台展示设置
	 * @param expert
	 * @return
	 */
	@RequestMapping(value="/setting/{mark}",method=RequestMethod.POST)
	public String setting(@PathVariable("mark") String mark,AchvNew achvNew){
		achvService.updateAchv(achvNew);
		return "redirect:" + adminPath + "/achv/join/"+mark;   
	}
}
