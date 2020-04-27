package com.bbu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");
		//下载文件，需要设置消息头
		response.addHeader("content-Type","application/octet-stream" );  //MIME类型，二进制（任意文件）
		//对于不同浏览器，进行不同的处理
		//获取客户端的user-agent信息
		String agent = request.getHeader("User-Agent");
		if(agent.toLowerCase().indexOf("firefox")!=-1) {    //为了简单处理，只处理了两个浏览器
			//firefox下载   文件名乱码问题
			response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+ new String(Base64.encodeBase64(filename.getBytes("utf-8")))+"?=");//filename包含了文件后缀
		}else {
		//edge下载乱码问题
		response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename, "utf-8"));//filename包含了文件后缀
		}
		//Servlet通过文件的地址  将文件转为输入流 读到Servlet中
		InputStream in = getServletContext().getResourceAsStream("/res/"+filename);
		
		//通过输出流  将刚才已经转为输入流文件    输出给用户
	     ServletOutputStream out = response.getOutputStream();
	     //创建一个缓冲区
	      byte[] bs = new byte[10];
	      //判断输入流中的数据是否已经读完标识
	      int len=-1;
	      //循环将输入流读入到 缓冲区当中，((len=in.read(bs)))!=-1就表示in里面还有数据
	      while((len=in.read(bs))!=-1) {
	    	  out.write(bs,0,len);
	      }
	      out.close();
	      in.close();
		
	}

}
