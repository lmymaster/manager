package com.bbu.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.util.VCodeGenerator;

@WebServlet("/validateServlet")
public class validateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VCodeGenerator vcGenerator = new VCodeGenerator();
		//生成验证码
		String vcode = vcGenerator.generatorVCode();
		//将验证码保存在session域中,以便判断验证码是否正确
		request.getSession().setAttribute("vcode", vcode);
		//System.out.println("code="+request.getSession().getAttribute("vcode"));
		//生成验证码图片
		BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
		//输出图像
		ImageIO.write(vImg, "gif", response.getOutputStream());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
