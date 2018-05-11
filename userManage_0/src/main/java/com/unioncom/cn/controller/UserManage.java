package com.unioncom.cn.controller;

import com.unioncom.cn.bean.Contions;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/31.
 */
@Controller
@RequestMapping(path = "/userManage")
public class UserManage {
    public String condtion(@ModelAttribute Contions contions, HttpSession httpSession, HttpRequest httpRequest){
       return  "test" ;
    }
}
