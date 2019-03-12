package com.sias.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sias.entity.User;
import com.sias.service.UserService;

@Controller //ָ���ǿ������ࣨ�����������ࣩ
@RequestMapping("/user") //==namesapce

public class UserController {
	
	@Autowired //�Զ�ע��service
	private UserService userService;
	
	
	//��½
	@RequestMapping("/login.do") //==actionName
	public String login(String name,String password,
			String clientCode,HttpSession session){
		
		/**
		 * 1.ȡ��session�е���֤�������
		 * 2.��ͻ��˵ĶԱ�
		 */
		String serverCode = (String) session.getAttribute("serverCode");
		// ���Դ�Сд��֤
		if(serverCode.equalsIgnoreCase(clientCode)){
		  User user = userService.queryUser(name, password);
		  
		   if(user != null){
			 session.setAttribute("user",user);
			 return "redirect:/dep/showDep.do"; //��ѯ����Ա��action
		 }else{
			 return "redirect:/login.jsp"; //��½jsp
	     }
		   
	   }else{
		 return "redirect:/login.jsp"; //��½jsp
	  }
	}	
	//ע��������֤
	@RequestMapping(value="/checkName.do")
	@ResponseBody //springMvc�Զ���jackson������ֵת����json�ַ���
		public User checkName(String name){
		User user = userService.queryByNa(name);
		return user;
		//return "ok";,produces="text/html;charset=UTF-8;
	}
	
	//ע��
	@RequestMapping("/regist.do")
	public String regist(String name,String realName,String password,Integer sex){
		
		userService.insertUser(new User(null,name,realName,password,sex));
		
			  return "redirect:/login.jsp"; //��½jsp
		}
	
	//�뿪
	@RequestMapping("/out.do")
	public String out(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
