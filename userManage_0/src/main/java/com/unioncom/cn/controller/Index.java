package com.unioncom.cn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unioncom.cn.bean.Contions;
import com.unioncom.cn.bean.LoginLog;
import com.unioncom.cn.convert.StringToDateConverter;
import com.unioncom.cn.service.LoginLogService;

/**
 * Created by Administrator on 2018/1/29.
 * 该类包含header的各类链接
 */

@Controller
public class Index {
	@Autowired
	LoginLogService LoginLogService;

	@RequestMapping("/2")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/3")
	public String userManage() {
		return "userCount";
	}
	
	@RequestMapping("/4")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/actSys")
	public String menuActSys() {
		return "acitveSys/menuActSys";
	}
	
	@RequestMapping("/actUser")
	public String menuActUser() {
		return "activeUser/menuActUser";
	}
	
	@RequestMapping("/exceptionBorad")
	public String exceptionBorad() {
		return "exception/menuException";
	}
	
	@RequestMapping("/search1")
	public String searchByConditions(Contions contions) {
		String city = contions.getCity();
		String sysname = contions.getSysname();
		Date beginTime = contions.getBegintime();
		Date endTime = contions.getEmdtime();

		// reture the result of look up by conditions given
		return "d";
	}

	@RequestMapping("userCount")
	public String userCount(Model model) {
		// 找到所有记录
		List<LoginLog> logs = LoginLogService.getAll();
		model.addAttribute("logs", logs);
		addDistinctAtt(model);
		return "detail/menuDetail";
	}

	private void addDistinctAtt(Model model) {
		List<LoginLog> logs = LoginLogService.getAll();
		List<String> cities = new ArrayList<String>();
		List<String> sysnames = new ArrayList<String>();
		for (LoginLog log : logs) {
			if (!cities.contains(log.getCity()))
				cities.add(log.getCity());
			if (!sysnames.contains(log.getSysname()))
				sysnames.add(log.getSysname());
		}
		model.addAttribute("cities", cities);
		model.addAttribute("sysnames", sysnames);
	}

	@RequestMapping("userCount/search")
	public String search(Model model, HttpServletRequest request) {
		// validate校验前台数据，并将搜索关键字放入Map中
		// Map<String, String> keys = validate(request);
		// 找到搜索记录
		String key = request.getParameter("search");
		String city = request.getParameter("city");
		String sysname = request.getParameter("sysname");

		// 获取时间
		StringToDateConverter converter = new StringToDateConverter("yyyy-MM-dd");
		Date beginTime = converter.convert(request.getParameter("beginTime"));
		Date endTime = converter.convert(request.getParameter("endTime"));
		// System.out.println(key);
		// 根据各属性来搜索
		List<LoginLog> conditions_logs = LoginLogService.findByConditions(key, city, sysname, beginTime, endTime);
		model.addAttribute("logs", conditions_logs);
		addDistinctAtt(model);
		addSelectedAtt(model, city, sysname, request.getParameter("beginTime"), request.getParameter("endTime"));
		return "detail/menuDetail";
	}

	private void addSelectedAtt(Model model, String city, String sysname, String beginTime, String endTime) {
		model.addAttribute("scity", city);
		model.addAttribute("ssysname", sysname);
		model.addAttribute("sbeginTime", beginTime);
		model.addAttribute("sendTime", endTime);
	}
	
	@RequestMapping("getUser")
	public boolean findUser() {
		return false;
	}
}
