package com.sias.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	
	//��jsp������ɺ�ִ��
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//�ڿ�����ִ����Ϻ�ִ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	/*
	 * ������Ĺ��ܵķ���(non-Javadoc)
	 * ����ֵ true-��������ִ�� false--�ж�����
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp,
			Object obj) throws Exception {
		HttpSession session = req.getSession();
		obj = session.getAttribute("user");
		if(obj == null){ //δ��½
			rsp.sendRedirect(req.getContextPath()+"/login.jsp");
		    return false;
		}else{ //��������ִ��
			return true;
		}
		
	}

}
