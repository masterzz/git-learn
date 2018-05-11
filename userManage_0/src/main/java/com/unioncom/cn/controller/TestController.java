package com.unioncom.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/1/31.
 */
@Controller
public class TestController {

    @RequestMapping("/search")
    public  String reach(@RequestParam (value = "testValue",required = false,defaultValue = "the old value") String test, Model model){
        test = "the new value";
        model.addAttribute("testValue",test);
        return "test";
    }
}
