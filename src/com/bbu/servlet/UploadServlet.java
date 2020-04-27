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
		//�ϴ�
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);  //�ж�ǰ̨form�Ƿ�������  enctype="multipart/form-data"��������ڽ����ϴ��ļ�
			if(isMultipart) {//�ж�ǰ̨��form�Ƿ���multipart����
				
				//1.����һ��DiskFileItemFactory����
				DiskFileItemFactory factory = new DiskFileItemFactory();// ctrl+t ��ʵ����
				//2.����һ���ļ��ϴ�������
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setHeaderEncoding("utf-8");
				//�����ϴ��ļ�ʱ���õ�����ʱ�ļ���С      DiskFileItemFactory factory  
				factory.setSizeThreshold(10240);//������ʱ�Ļ����СΪ10kb
				factory.setRepository(new File("E:\\uploadtemp")); //������ʱĿ¼�ļ�
				//�����ļ���С       ServletFileUpload upload
				upload.setSizeMax(1024*1024);//�ֽ�
				
				//ͨ��parseRequest����form�е����������ֶΣ������浽items�����У���ǰ̨���ݵ�sno sname spicture��ʱ�ͱ�������items�У�
				List<FileItem> items = upload.parseRequest(request);
			
				//����items�е����ݣ�sno sname spicture��
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();//�õ�name����ֵ
					
					//�ж�ǰ̨�ֶ� ����ͨform ���ֶΣ�sno sname�� ,�����ļ��ֶ�
					if(item.isFormField()) {
						if(itemName.equals("sno")) {//����name���ԣ��ж�item��sno sname ����spicture
							//int sno = Integer.parseInt(item.getString("utf-8"));
					    }else if(itemName.equals("sname")) {
					    	//String sname = item.getString("utf-8");
					    }else {
					    	System.out.println("�����ֶ�....");
					    }	
					}else {//�ļ��ϴ�
						//getFildName�ǻ�ȡ��ͨ�����ֶ�nameֵ
						//getName ��ȡ�ļ���
						String filename = FilenameUtils.getName(item.getName());  //a.txt  a.docx  a.gif
						//�����ļ�����
						String ext = filename.substring(filename.indexOf(".")+1);  //��ȡ�ļ�����ź�������ݣ������ж�
						if(!(ext.equals("png")||ext.equals("gif")||ext.equals("jpg"))) {
						System.out.println("ͼƬ�������󣡸�ʽֻ��Ϊpng��gif��jpg");	
						return;  //�ϴ�ʧ�ܣ���ֹ
						}
						//��ȡ�ļ�����
						//�����ļ�·�����ƶ��ϴ�λ�ã�������·����
						//��ȡ������·��
				//	String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "E:\\upload";
						File file = new File(path,filename);
						item.write(file);
						System.out.println("�ϴ��ɹ�");
						request.setAttribute("message"," �ļ��ϴ��ɹ���"+path);
						request.getRequestDispatcher("main.jsp").forward(request, response);
						return;			
				      }	
				  }
			}
		}catch(FileUploadBase.SizeLimitExceededException e){
			System.out.println("ͼƬ̫����,�����ļ���С����");
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
