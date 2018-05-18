package com.unioncom.cn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unioncom.cn.bean.Contions;
import com.unioncom.cn.bean.LoginLog;
import com.unioncom.cn.convert.StringToDateConverter;
import com.unioncom.cn.service.LoginLogService;
import com.unioncom.cn.utils.MyPageHelper;
import com.unioncom.cn.utils.StringUtils;

/**
 * Created by Administrator on 2018/1/29. 该类包含header的各类链接
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

	/*@RequestMapping("userCount")
	public String userCount(Model model, HttpServletRequest request) {
		// 找到所有记录
		List<LoginLog> logs = LoginLogService.getAll();
		// 进行分页
		MyPageHelper<LoginLog> pageHelper = new MyPageHelper<LoginLog>(logs);
		String str_page = request.getParameter("page");
		int page = Integer.parseInt(str_page == null ? "1" : str_page);
		List<LoginLog> frontLogs = pageHelper.getPage(page, 20);
		model.addAttribute("page", page);
		model.addAttribute("page_length", pageHelper.getLength());
		model.addAttribute("logs", frontLogs);
		// 增加其他参数
		addDistinctAtt(model);
		return "detail/menuDetail";
	}*/

	@RequestMapping("userCount")
	public String search(Model model, HttpServletRequest request) {
		// validate校验前台数据，并将搜索关键字放入Map中
		// Map<String, String> searchs = validate(request);
		// 找到搜索记录
		String search = StringUtils.handleEmpty(request.getParameter("search"));
		String city = StringUtils.handleEmpty(request.getParameter("city"));
		String sysname = StringUtils.handleEmpty(request.getParameter("sysname"));

		String str_beginTime = StringUtils.handleEmpty(request.getParameter("beginTime"));
		String str_endTime = StringUtils.handleEmpty(request.getParameter("endTime"));
		
		model.addAttribute("search", search);
		model.addAttribute("city", city);
		model.addAttribute("sysname", sysname);
		model.addAttribute("beginTime", str_beginTime);
		model.addAttribute("endTime", str_endTime);
		
		// 获取时间
		StringToDateConverter converter = new StringToDateConverter("yyyy-MM-dd");
		Date beginTime = converter.convert(str_beginTime);
		Date endTime = converter.convert(str_endTime);
		// System.out.println(search);
		// 根据各属性来搜索
		List<LoginLog> conditions_logs = LoginLogService.findByConditions(search, city, sysname, beginTime, endTime);
		// 进行分页
		MyPageHelper<LoginLog> pageHelper = new MyPageHelper<LoginLog>(conditions_logs);
		String str_page = request.getParameter("page");
		int page = Integer.parseInt(str_page == null ? "1" : str_page);
		List<LoginLog> frontLogs = pageHelper.getPage(page, 20);
		model.addAttribute("page", page);
		model.addAttribute("page_length", pageHelper.getLength());
		model.addAttribute("logs", frontLogs);
		addDistinctAtt(model,request);
		addSelectedAtt(model, city, sysname, request.getParameter("beginTime"), request.getParameter("endTime"));
		return "detail/menuDetail";
	}
	
	//添加选项中的细项
	private void addDistinctAtt(Model model, HttpServletRequest request) {
		//将选择的细项再添加到model中
		String default_city = request.getParameter("city");
		model.addAttribute("default_city", default_city);
		String default_sysname = StringUtils.handleEmpty(request.getParameter("default_sysname"));
		model.addAttribute("default_sysname", default_sysname);		
		
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
