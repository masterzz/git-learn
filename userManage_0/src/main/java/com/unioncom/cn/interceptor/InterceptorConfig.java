package com.unioncom.cn.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorConfig implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

	/**
	 * 进入controller层之前拦截请求
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
			throws Exception {

		log.info("---------------------开始进入请求地址拦截----------------------------");
		HttpSession session = request.getSession();
		if (!StringUtils.isEmpty(session.getAttribute("username"))) {
			return true;
		} else {
			//这句话的意思，是让浏览器用utf8来解析返回的数据  
	        response.setHeader("Content-type", "text/html;charset=UTF-8");  
			PrintWriter printWriter = response.getWriter();
			printWriter.write("未登陆，3秒后跳转至登陆页面");
			response.setHeader("refresh", "3;URL=login_page");
//			request.getRequestDispatcher("login_page").forward(request, response);
			return false;
		}

	}


	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
		log.info("---------------视图渲染之后的操作-------------------------0");
	}


	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
