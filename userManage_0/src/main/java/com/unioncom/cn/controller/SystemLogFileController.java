package com.unioncom.cn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unioncom.cn.bean.Contions;
import com.unioncom.cn.bean.LoginLog;
import com.unioncom.cn.bean.SystemLogFile;
import com.unioncom.cn.convert.StringToDateConverter;
import com.unioncom.cn.service.SystemLogFileService;

/**
 * Created by Administrator on 2018/1/29.
 */

@Controller
public class SystemLogFileController {
	@Autowired
	SystemLogFileService systemLogFileService;


	@RequestMapping("/systemLogFile")
//	@ResponseBody
	public String userManage(Model model) {
		List<SystemLogFile> sys_log_files = systemLogFileService.getAll();
		
		for(SystemLogFile file : sys_log_files) {
			System.out.println(file.getFile_name());
			System.out.println(file.getIp());
			System.out.println(file.getMkdir());
			System.out.println(file.getPerson_in_charge());
			System.out.println(file.getPort());
			System.out.println(file.getSize());
			System.out.println(file.getSysname_cn());
			System.out.println(file.getSystime());
			System.out.println(file.getId());
			System.out.println("--------------------");
		}
		
		model.addAttribute("sys_log_files", sys_log_files);
		
		return "system_log_file";
	}




}
