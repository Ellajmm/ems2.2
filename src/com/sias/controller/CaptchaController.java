package com.sias.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sias.util.SecurityCode;
import com.sias.util.SecurityImage;

@Controller
@RequestMapping("/cap")
public class CaptchaController {
	/**
	 * 生成验证码
	 * 	1. 需要使用IO流响应验证码图片， 方法的返回值类型为void
	 * @throws Exception 
	 */
	@RequestMapping("/generateCaptcha.do") 
	public void generateCaptcha(HttpServletResponse response,
				HttpSession session) throws Exception{ 
		//1. 生成验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		//2. 将随机数保存到session中， 以便未来做登录验证 
		session.setAttribute("serverCode", securityCode); 
		//3. 获取验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode); 
		//4. 使用IO流响应到客户端
		OutputStream out = response.getOutputStream();
		/**
		 * 第一个参数  指定验证码图片对象
		 * 第二个参数 指定图片类型
		 * 第三个参数 指定输出流
		 */
		ImageIO.write(image, "png", out);
	}
}
