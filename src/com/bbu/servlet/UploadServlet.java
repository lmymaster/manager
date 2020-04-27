package com.bbu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//上传
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);  //判断前台form是否有属性  enctype="multipart/form-data"，如果有在进行上传文件
			if(isMultipart) {//判断前台的form是否有multipart属性
				
				//1.创建一个DiskFileItemFactory工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();// ctrl+t 找实现类
				//2.创建一个文件上传解析器
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("utf-8");
				//设置上传文件时，用到的临时文件大小      DiskFileItemFactory factory  
				factory.setSizeThreshold(10240);//设置临时的缓冲大小为10kb
				factory.setRepository(new File("E:\\uploadtemp")); //设置临时目录文件
				//控制文件大小       ServletFileUpload upload
				upload.setSizeMax(1024*1024);//字节
				
				//通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前台传递的sno sname spicture此时就保存在了items中）
				List<FileItem> items = upload.parseRequest(request);
			
				//遍历items中的数据（sno sname spicture）
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();//拿到name属性值
					
					//判断前台字段 是普通form 表单字段（sno sname） ,还是文件字段
					if(item.isFormField()) {
						if(itemName.equals("sno")) {//根据name属性，判断item是sno sname 还是spicture
							//int sno = Integer.parseInt(item.getString("utf-8"));
					    }else if(itemName.equals("sname")) {
					    	//String sname = item.getString("utf-8");
					    }else {
					    	System.out.println("其他字段....");
					    }	
					}else {//文件上传
						//getFildName是获取普通表单的字段name值
						//getName 获取文件名
						String filename = FilenameUtils.getName(item.getName());  //a.txt  a.docx  a.gif
						//控制文件类型
						String ext = filename.substring(filename.indexOf(".")+1);  //截取文件名点号后面的内容，进行判断
						if(!(ext.equals("png")||ext.equals("gif")||ext.equals("jpg"))) {
						System.out.println("图片类型有误！格式只能为png、gif、jpg");	
						return;  //上传失败，终止
						}
						//获取文件内容
						//定义文件路径：制定上传位置（服务器路径）
						//获取服务器路径
				//	String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "E:\\upload";
						File file = new File(path,filename);
						item.write(file);
						System.out.println("上传成功");
						request.setAttribute("message"," 文件上传成功到"+path);
						request.getRequestDispatcher("main.jsp").forward(request, response);
						return;			
				      }	
				  }
			}
		}catch(FileUploadBase.SizeLimitExceededException e){
			System.out.println("图片太大了,超过文件大小限制");
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
