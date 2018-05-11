package com.unioncom.cn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unioncom.cn.bean.SystemLogFile;
import com.unioncom.cn.bean.User;
import com.unioncom.cn.convert.StringToDateConverter;
import com.unioncom.cn.service.SystemLogFileService;
import com.unioncom.cn.service.UserService;

/**
 * 该controller负责处理用户的注册、登录、注销等操作
 * 
 * @author 朱斌荣
 *
 */
@Controller
public class UserController {
	// 注册部分
	@Autowired
	SystemLogFileService systemLogFileService;

	@Autowired
	UserService userService;

	// 注册完之后返回登录界面
	@RequestMapping("/register_page")
	public String register() {
		return "register/menuRegister";
	}

	@RequestMapping("/register_save")
	public String registerSave(HttpServletRequest request) {
		// 统一的时间转换器
		StringToDateConverter converter = new StringToDateConverter("yyyy-MM-dd");
		// 存储User部分
		User user = makeUser(request);
		userService.save(user);

		// 存储系统信息部分
		SystemLogFile systemLogFile = makeSystemLogFile(request, converter);
		systemLogFileService.save(systemLogFile);

		// return "forward:/hello" => 转发到能够匹配 /hello 的 controller 上
		// return "hello" => 实际上还是转发，只不过是框架会找到该逻辑视图名对应的 View 并渲染
		// return "/hello" => 同 return "hello"

		// "redirect:/hello" => 重定向到/hello
		return "redirect:/login_page";
	}

	@RequestMapping("/connect")
	@ResponseBody
	public String connect(HttpServletRequest request) {
		String ip = request.getParameter("ip");
		String port = request.getParameter("port");
		return userService.connect(ip, Integer.parseInt(port));
	}

	private SystemLogFile makeSystemLogFile(HttpServletRequest request, StringToDateConverter converter) {
		SystemLogFile systemLogFile = new SystemLogFile();
		String sysname_en = request.getParameter("sysname_en");
		String sysname_cn = request.getParameter("sysname_cn");
		String person_in_charge = request.getParameter("sysname_cn");
		String ip = request.getParameter("ip");
		String mkdir = request.getParameter("mkdir");
		String file_name = request.getParameter("file_name");
		String size = request.getParameter("size");
		Date systime = converter.convert(request.getParameter("systime"));
		String port = request.getParameter("port");

		systemLogFile.setFile_name(file_name);
		systemLogFile.setIp(ip);
		systemLogFile.setMkdir(mkdir);
		systemLogFile.setPerson_in_charge(person_in_charge);
		systemLogFile.setPort(port);
		systemLogFile.setSize(size);
		systemLogFile.setSysname_cn(sysname_cn);
		systemLogFile.setSysname_en(sysname_en);
		systemLogFile.setSystime(systime);
		return systemLogFile;
	}

	private User makeUser(HttpServletRequest request) {
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setPhone_number(phone_number);
		user.setEmail(email);
		return user;
	}

	// 登录部分
	@RequestMapping("/login_page")
	public String login() {
		return "login";
	}

	// 提交请求
	@RequestMapping("/login_submit")
	public String login_submit(HttpServletRequest request) {
		// 获取用户名、密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.findByNameAndPassword(username, password);
		if (user != null)
			return "redirect:/home_page";
		else
			return "login";
	}

	 /**
     * 校验当前登录名
     * @param username 登录名
     * @param userId 用户ID（用户已经存在，即又改回原来的名字还是唯一的）
     * @return
     */
    @RequestMapping(value = "/oauth/checkUnique")
    @ResponseBody
    public boolean checkExist(String username) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        User user = userService.findByUsername(username);
        //用户不存在，校验有效
        if (user == null) {
        	return true;
        } else {
        	return false;
        }
    }
}
