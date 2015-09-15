/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.modules.web.news;

import cn.fundview.common.utils.StringUtils;
import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.News;
import cn.fundview.modules.service.NewsService;
import cn.fundview.setting.model.Dict;
import cn.fundview.setting.service.DictService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 字典Controller
 * @author wangjian
 * @version 2014-05-16
 */
@Controller
@RequestMapping(value = "${adminPath}/news")
public class NewsController extends BaseController {

	@Autowired
	private NewsService newsService;
	
	@ModelAttribute
	public News get(@RequestParam(required=false) Integer id) {
		if (null!=id){
			return newsService.get(id);
		}else{
			return new News();
		}
	}

	/**
	 * 新闻管理主页
	 * @return
	 */
	@RequiresPermissions("news:list:view")
	@RequestMapping(value = {"index", ""})
	public String index() {
		return "modules/news/index";
	}

	/**
	 * DataTables获取新闻列表,分页并全局搜索
	 * @param request 	请求
	 * @param response	返回
	 * @return json数据
	 */
	@RequiresPermissions("news:list:view")
	@RequestMapping(value = {"list"})
	@ResponseBody
	public String list (HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = Maps.newHashMap();
		map.put("data",newsService.findAll());
		map.put("draw",1);
		map.put("recordsTotal",27);
		map.put("recordsFiltered",27);
		return JSON.toJSONString(map);
	}


	@RequiresPermissions("news:list:view")
	@RequestMapping(value = "form")
	public String form(News news, Model model) {
		model.addAttribute("news", news);
		return "modules/news/form";
	}

	@RequiresPermissions("news:list:edit")
	@RequestMapping(value = "save")
	public String save(News news, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, news)){
			return form(news, model);
		}
		newsService.save(news);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + adminPath + "/news/index";
	}

	@RequiresPermissions("news:list:edit")
	@RequestMapping(value = "delete")
	public String delete(News news, RedirectAttributes redirectAttributes) {
		newsService.delete(news);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + adminPath + "/news/index";
	}

}
