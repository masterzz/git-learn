package com.unioncom.cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {
    
	/**
	 * 1，写一个类，类中有一个方法，类似于hello，能够在页面上输出，这是我的demo
	 * 2，试着写一个repository，能够从数 据库中查询数据，输出到控制台
	 * @return
	 */ 

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello everybody！！";
    }
    
    @RequestMapping("/hello11/{id}")
    @ResponseBody
    public String hello11(@PathVariable Long id, Model model) {
    	return "hello mvc " + id;
    }
    
   /* public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }*/

}