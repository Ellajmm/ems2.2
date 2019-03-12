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

@Controller //指明是控制器类（区别于其它类）
@RequestMapping("/user") //==namesapce

public class UserController {
	
	@Autowired //自动注入service
	private UserService userService;
	
	
	//登陆
	@RequestMapping("/login.do") //==actionName
	public String login(String name,String password,
			String clientCode,HttpSession session){
		
		/**
		 * 1.取出session中的验证码随机数
		 * 2.与客户端的对比
		 */
		String serverCode = (String) session.getAttribute("serverCode");
		// 忽略大小写验证
		if(serverCode.equalsIgnoreCase(clientCode)){
		  User user = userService.queryUser(name, password);
		  
		   if(user != null){
			 session.setAttribute("user",user);
			 return "redirect:/dep/showDep.do"; //查询所有员工action
		 }else{
			 return "redirect:/login.jsp"; //登陆jsp
	     }
		   
	   }else{
		 return "redirect:/login.jsp"; //登陆jsp
	  }
	}	
	//注册姓名验证
	@RequestMapping(value="/checkName.do")
	@ResponseBody //springMvc自动用jackson将返回值转换成json字符串
		public User checkName(String name){
		User user = userService.queryByNa(name);
		return user;
		//return "ok";,produces="text/html;charset=UTF-8;
	}
	
	//注册
	@RequestMapping("/regist.do")
	public String regist(String name,String realName,String password,Integer sex){
		
		userService.insertUser(new User(null,name,realName,password,sex));
		
			  return "redirect:/login.jsp"; //登陆jsp
		}
	
	//离开
	@RequestMapping("/out.do")
	public String out(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
