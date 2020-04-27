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
		//�����ļ�����Ҫ������Ϣͷ
		response.addHeader("content-Type","application/octet-stream" );  //MIME���ͣ������ƣ������ļ���
		//���ڲ�ͬ����������в�ͬ�Ĵ���
		//��ȡ�ͻ��˵�user-agent��Ϣ
		String agent = request.getHeader("User-Agent");
		if(agent.toLowerCase().indexOf("firefox")!=-1) {    //Ϊ�˼򵥴���ֻ���������������
			//firefox����   �ļ�����������
			response.addHeader("content-Disposition","attachment;filename==?UTF-8?B?"+ new String(Base64.encodeBase64(filename.getBytes("utf-8")))+"?=");//filename�������ļ���׺
		}else {
		//edge������������
		response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename, "utf-8"));//filename�������ļ���׺
		}
		//Servletͨ���ļ��ĵ�ַ  ���ļ�תΪ������ ����Servlet��
		InputStream in = getServletContext().getResourceAsStream("/res/"+filename);
		
		//ͨ�������  ���ղ��Ѿ�תΪ�������ļ�    ������û�
	     ServletOutputStream out = response.getOutputStream();
	     //����һ��������
	      byte[] bs = new byte[10];
	      //�ж��������е������Ƿ��Ѿ������ʶ
	      int len=-1;
	      //ѭ�������������뵽 ���������У�((len=in.read(bs)))!=-1�ͱ�ʾin���滹������
	      while((len=in.read(bs))!=-1) {
	    	  out.write(bs,0,len);
	      }
	      out.close();
	      in.close();
		
	}

}
