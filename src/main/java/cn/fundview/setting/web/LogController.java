/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fundview.common.web.BaseController;
import cn.fundview.setting.model.Log;
import cn.fundview.setting.service.LogService;

/**
 * 日志Controller
 * @author wangjian
 * @version 2013-6-2
 */
@Controller
@RequestMapping(value = "${adminPath}/log")
public class LogController extends BaseController {

	@Autowired
	private LogService logService;
	
	@RequiresPermissions("sys:log:view")
	@RequestMapping(value = {"index", ""})
	public String index(Log log, HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Log> list = logService.findList(log);
        model.addAttribute("list", list);
		return "modules/log/index";
	}

}
