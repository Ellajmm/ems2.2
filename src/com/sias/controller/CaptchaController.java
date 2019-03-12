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
	 * ������֤��
	 * 	1. ��Ҫʹ��IO����Ӧ��֤��ͼƬ�� �����ķ���ֵ����Ϊvoid
	 * @throws Exception 
	 */
	@RequestMapping("/generateCaptcha.do") 
	public void generateCaptcha(HttpServletResponse response,
				HttpSession session) throws Exception{ 
		//1. ������֤�������
		String securityCode = SecurityCode.getSecurityCode();
		//2. ����������浽session�У� �Ա�δ������¼��֤ 
		session.setAttribute("serverCode", securityCode); 
		//3. ��ȡ��֤��ͼƬ
		BufferedImage image = SecurityImage.createImage(securityCode); 
		//4. ʹ��IO����Ӧ���ͻ���
		OutputStream out = response.getOutputStream();
		/**
		 * ��һ������  ָ����֤��ͼƬ����
		 * �ڶ������� ָ��ͼƬ����
		 * ���������� ָ�������
		 */
		ImageIO.write(image, "png", out);
	}
}
