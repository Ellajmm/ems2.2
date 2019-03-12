package com.sias.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	
	//在jsp解析完成后执行
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//在控制器执行完毕后执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * 定义核心功能的方法(non-Javadoc)
	 * 返回值 true-继续向下执行 false--中断请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp,
			Object obj) throws Exception {
		HttpSession session = req.getSession();
		obj = session.getAttribute("user");
		if(obj == null){ //未登陆
			rsp.sendRedirect(req.getContextPath()+"/login.jsp");
		    return false;
		}else{ //继续向下执行
			return true;
		}
		
	}

}
