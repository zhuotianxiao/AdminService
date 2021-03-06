/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.fundview.common.config.Global;
import cn.fundview.common.utils.StringUtils;
import cn.fundview.common.web.BaseController;
import cn.fundview.setting.model.Office;
import cn.fundview.setting.model.User;
import cn.fundview.setting.service.OfficeService;
import cn.fundview.setting.utils.UserUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 机构Controller
 * @author wangjian
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/office")
public class OfficeController extends BaseController {

	@Autowired
	private OfficeService officeService;
	
	@ModelAttribute("office")
	public Office get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return officeService.get(id);
		}else{
			return new Office();
		}
	}

	@RequiresPermissions("sys:office:view")
	@RequestMapping(value = {"index"})
	public String index(Office office, Model model) {
        model.addAttribute("list", officeService.findAll());
		return "modules/office/index";
	}

	@RequiresPermissions("sys:office:view")
	@RequestMapping(value = {"list"})
	@ResponseBody
	public HashMap<String, List<Office>> list(Office office, Model model) {
		HashMap<String, List<Office>> map = Maps.newHashMap();
		List<Office> offices = officeService.findAll();
		map.put("aaData",offices);
		return map;
	}

	@RequestMapping(value = {"detail"})
	@ResponseBody
	public Office detail(Office office, Model model) {
		Office returnOffice = officeService.get(office);
		return returnOffice;
	}
	
	@RequiresPermissions("sys:office:view")
	@RequestMapping(value = "form")
	public String form(Office office, Model model) {
		User user = UserUtils.getUser();
		List<Office> list = Lists.newArrayList();
		if (office.getParent()==null || office.getParent().getId()==null){
			office.setParent(user.getOffice());
		}
		office.setParent(officeService.get(office.getParent().getId()));
		if (office.getArea()==null){
			office.setArea(user.getOffice().getArea());
		}
		// 自动获取排序号
		if (StringUtils.isBlank(office.getId())&&office.getParent()!=null){
			int size = 0;
			list = officeService.findAll();
			for (int i=0; i<list.size(); i++){
				Office e = list.get(i);
				if (e.getParent()!=null && e.getParent().getId()!=null
						&& e.getParent().getId().equals(office.getParent().getId())){
					size++;
				}
			}
			office.setCode(office.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size+1 : 1), 3, "0"));
		}else{
			list = officeService.findAll();
		}
		model.addAttribute("office", office);
		model.addAttribute("list",list);
		return "modules/office/form";
	}

	@RequiresPermissions("sys:office:view")
	@RequestMapping(value = "add")
	public String add(Office office, Model model) {
		List<Office> offices = officeService.findAll();
		model.addAttribute("offices",offices);
		return "modules/sys/officeForm";
	}

	@RequiresPermissions("sys:office:edit")
	@RequestMapping(value = "save")
	public String save(Office office, Model model, RedirectAttributes redirectAttributes) {

		if (!beanValidator(model, office)){
			return form(office, model);
		}

		officeService.save(office);
		
		addMessage(redirectAttributes, "保存机构'" + office.getName() + "'成功");
		return "redirect:" + adminPath + "/office/index";
	}

	@RequiresPermissions("sys:office:edit")
	@RequestMapping(value = "formUpdate")
	public String update(Office office, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, office)){
			return form(office, model);
		}
		officeService.save(office);

		addMessage(redirectAttributes, "保存机构'" + office.getName() + "'成功");
		return "redirect:" + adminPath + "/sys/office";
	}

	@RequiresPermissions("sys:office:edit")
	@RequestMapping(value = "delete")
	public String delete(Office office, RedirectAttributes redirectAttributes) {
		officeService.delete(office);
		addMessage(redirectAttributes, "删除机构成功");
		return "redirect:" + adminPath + "/office/index";
	}

	/**
	 * 获取机构JSON数据。
	 * @param extId 排除的ID
	 * @param type	类型（1：公司；2：部门/小组/其它：3：用户）
	 * @param grade 显示级别
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String type,
			@RequestParam(required=false) Long grade, @RequestParam(required=false) Boolean isAll, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Office> list = officeService.findList(isAll);
		for (int i=0; i<list.size(); i++){
			Office e = list.get(i);
			if ((StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1))
					&& (type == null || (type != null && (type.equals("1") ? type.equals(e.getType()) : true)))
					&& (grade == null || (grade != null && Integer.parseInt(e.getGrade()) <= grade.intValue()))
					&& Global.YES.equals(e.getUseable())){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("pIds", e.getParentIds());
				map.put("name", e.getName());
				if (type != null && "3".equals(type)){
					map.put("isParent", true);
				}
				mapList.add(map);
			}
		}
		return mapList;
	}
}
