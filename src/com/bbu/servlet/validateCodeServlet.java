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

	Color getRandColor(int fc, int bc) {//������Χ��������ɫ   
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
	    //����ҳ�治����   
	    response.setHeader("Pragma", "No-cache");   
	    response.setHeader("Cache-Control", "no-cache");   
	    response.setDateHeader("Expires", 0);   
	   
	    // ���ڴ��д���ͼ��   
	    int width = 60, height = 20;   
	    BufferedImage image = new BufferedImage(width, height,   
	            BufferedImage.TYPE_INT_RGB);   
	   
	    // ��ȡͼ��������   
	    Graphics g = image.getGraphics();   
	   
	    //���������   
	    Random random = new Random();   
	   
	    // �趨����ɫ   
	    g.setColor(getRandColor(200, 250));   
	    g.fillRect(0, 0, width, height);   
	   
	    //�趨����   
	    g.setFont(new Font("Times New Roman", Font.PLAIN, 18));   
	   
	    //���߿�   
	    //g.setColor(new Color());   
	    //g.drawRect(0,0,width-1,height-1);   
	   
	    // �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽   
	    g.setColor(getRandColor(160, 200));   
	    for (int i = 0; i < 100; i++) {   
	        int x = random.nextInt(width);   
	        int y = random.nextInt(height);   
	        int xl = random.nextInt(12);   
	        int yl = random.nextInt(12);   
	        g.drawLine(x, y, x + xl, y + yl);   
	    }   
	    String[] codes = {"2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};  
	    // ȡ�����������֤��(4λ����)��Ҳ�ɲο��α�P165����4�ַ�����֤�� 
	    String sRand = "";   
	    for (int i = 0; i < 4; i++) {   
	        String rand = String.valueOf(codes[random.nextInt(codes.length)]);   
	        sRand += rand;   
	        // ����֤����ʾ��ͼ����   
	        g.setColor(new Color(20 + random.nextInt(110), 20 + random   
	        .nextInt(110), 20 + random.nextInt(110)));//���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������   
	        g.drawString(rand, 13 * i + 6, 16);   
	    }   
	   
	    // ����֤�����SESSION   
	    request.getSession().setAttribute("code", sRand);   
	   System.out.println("code="+request.getSession().getAttribute("code"));
	    // ͼ����Ч   
	    g.dispose();   
	   
	    // ���ͼ��ҳ��   
	    ImageIO.write(image, "JPEG", response.getOutputStream()); 
		
	}

	
	
}
