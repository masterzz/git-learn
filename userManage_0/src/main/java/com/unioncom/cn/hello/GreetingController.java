package com.unioncom.cn.hello;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unioncom.cn.Dao.LoginLogRepository;
import com.unioncom.cn.bean.LoginLog;

/**
 * Created by Administrator on 2018/1/8.
 */
@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false , defaultValue = "world") String name , Model model){
        model.addAttribute("name", name);
        return "index";
    }
    
    @RequestMapping(value="/test/submit", method = RequestMethod.POST)
    public String test1(HttpServletRequest request) {
    	//尝试了很多次，确认一点，前台传过来的值用getParameter！！！不是getAttribute
    	System.out.println(request.getParameter("name"));
    	return "test";
    }
    
    @Autowired
    LoginLogRepository loginLogRepository;
    
    @RequestMapping(value="/test")
    public String test(HttpServletRequest request) throws Exception {
    	//获得2009年06月01日 的Date对象
    	DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    	Date startDate = dateFormat1.parse("2009-06-01");
    	List<LoginLog> logs = loginLogRepository.findByLoginTimeBetween(startDate, new Date());
    	return "test";
    }
}
