package com.bbu.servlet;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/validateCodeServlet")
public class validateCodeServlet extends HttpServlet {

	Color getRandColor(int fc, int bc) {//给定范围获得随机颜色   
        Random random = new Random();   
        if (fc > 255)   
            fc = 255;   
        if (bc > 255)   
            bc = 255;   
        int r = fc + random.nextInt(bc - fc);   
        int g = fc + random.nextInt(bc - fc);   
        int b = fc + random.nextInt(bc - fc);   
        return new Color(r, g, b);   
    }  
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException ,IOException {
	    //设置页面不缓存   
	    response.setHeader("Pragma", "No-cache");   
	    response.setHeader("Cache-Control", "no-cache");   
	    response.setDateHeader("Expires", 0);   
	   
	    // 在内存中创建图象   
	    int width = 60, height = 20;   
	    BufferedImage image = new BufferedImage(width, height,   
	            BufferedImage.TYPE_INT_RGB);   
	   
	    // 获取图形上下文   
	    Graphics g = image.getGraphics();   
	   
	    //生成随机类   
	    Random random = new Random();   
	   
	    // 设定背景色   
	    g.setColor(getRandColor(200, 250));   
	    g.fillRect(0, 0, width, height);   
	   
	    //设定字体   
	    g.setFont(new Font("Times New Roman", Font.PLAIN, 18));   
	   
	    //画边框   
	    //g.setColor(new Color());   
	    //g.drawRect(0,0,width-1,height-1);   
	   
	    // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到   
	    g.setColor(getRandColor(160, 200));   
	    for (int i = 0; i < 100; i++) {   
	        int x = random.nextInt(width);   
	        int y = random.nextInt(height);   
	        int xl = random.nextInt(12);   
	        int yl = random.nextInt(12);   
	        g.drawLine(x, y, x + xl, y + yl);   
	    }   
	    String[] codes = {"2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};  
	    // 取随机产生的认证码(4位数字)，也可参看课本P165生成4字符的验证码 
	    String sRand = "";   
	    for (int i = 0; i < 4; i++) {   
	        String rand = String.valueOf(codes[random.nextInt(codes.length)]);   
	        sRand += rand;   
	        // 将认证码显示到图象中   
	        g.setColor(new Color(20 + random.nextInt(110), 20 + random   
	        .nextInt(110), 20 + random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成   
	        g.drawString(rand, 13 * i + 6, 16);   
	    }   
	   
	    // 将验证码存入SESSION   
	    request.getSession().setAttribute("code", sRand);   
	   System.out.println("code="+request.getSession().getAttribute("code"));
	    // 图象生效   
	    g.dispose();   
	   
	    // 输出图象到页面   
	    ImageIO.write(image, "JPEG", response.getOutputStream()); 
		
	}

	
	
}
