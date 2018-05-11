package com.unioncom.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unioncom.cn.bean.SystemLog;
import com.unioncom.cn.bean.UserLog;
import com.unioncom.cn.service.SystemLogService;
import com.unioncom.cn.service.UserLogService;

/**
 * 该controller负责处理用户的注册、登录、注销等操作
 * 
 * @author 朱斌荣
 *
 */
@Controller
public class HomePageController {
	@Autowired
	SystemLogService systemLogService;
	@Autowired
	UserLogService userLogService;
	
	@RequestMapping("home_page")
	public String home(Model model) {
		List<SystemLog> systemLogs = systemLogService.getAll();
		List<UserLog> userLogs = userLogService.getAll();
		model.addAttribute("systemLogs", systemLogs);
		model.addAttribute("userLogs", userLogs);
		return "main";
	}
	
	@RequestMapping("header")
	public String header() {
		return "home_page/header";
	}
	
	@RequestMapping("footer")
	public String footer() {
		return "home_page/footer";
	}
	
	@RequestMapping("firstMain")
	public String firstMain() {
		return "home_page/firstPage/firstMain";
	}
}
