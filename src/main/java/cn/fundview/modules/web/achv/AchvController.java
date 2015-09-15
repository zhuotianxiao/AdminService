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
@RequestMapping("${adminPath}/achv/achv")
public class AchvController extends BaseController{
	
	@Autowired
	private AchvService achvService;
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
        model.addAttribute("list", achvService.findAll());
		return "modules/achv/achv/index";
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
		
		achvService.validAchv(id, flag);
		return "redirect:" + adminPath + "/achv/achv/index";
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
		//System.out.println(achvNew.getCreateDate());
		model.addAttribute("achvNew", achvNew);
		return "modules/achv/achv/info";
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
		AchvNew achvNew = new AchvNew();
		achvNew.setId(id+"");
		achvNew = achvService.get(achvNew);
		model.addAttribute("achvNew", achvNew);
		return "modules/achv/achv/setting";
	}
	/**
	 * 提交前台展示设置
	 * @param expert
	 * @return
	 */
	@RequestMapping(value="/setting",method=RequestMethod.POST)
	public String setting(AchvNew achvNew){
		achvService.updateAchv(achvNew);
		return "redirect:" + adminPath + "/achv/achv/index";   
	}
	
	
}
