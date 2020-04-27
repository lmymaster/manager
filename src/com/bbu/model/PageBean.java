package com.bbu.model;

import java.util.List;

public class PageBean {
	//程序员指定或者页面参数
		private int currentPage;//当前页
		private int pageSize;   //每页显示多少条
		
		//查询数据库
		private int recordCount;//数据库一共有多少条
		private List recordList;//本页显示的数据列表
		
		//计算
		private int pageCount;  //计算后得到的数值，总页数
		private int beginPageIndex;//页面列表的开始索引（包括）
		private int endPageIndex;  //页面列表的结束索引（包括）
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		public List getRecordList() {
			return recordList;
		}
		public void setRecordList(List recordList) {
			this.recordList = recordList;
		}
		public int getPageCount() {
			return pageCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		public int getBeginPageIndex() {
			return beginPageIndex;
		}
		public void setBeginPageIndex(int beginPageIndex) {
			this.beginPageIndex = beginPageIndex;
		}
		public int getEndPageIndex() {
			return endPageIndex;
		}
		public void setEndPageIndex(int endPageIndex) {
			this.endPageIndex = endPageIndex;
		}
		public PageBean(){
			
		}
		public PageBean(int currentPage,int pageSize,int recordCount,List recordList){
			this.currentPage=currentPage;
			this.pageSize=pageSize;
			this.recordCount=recordCount;
			this.recordList=recordList;
			//计算总页码
			pageCount=(recordCount+pageSize-1)/pageSize;		
			//计算beginPageIndex和endPageIndex
			//总页数不大于10，则全部显示
			if(pageCount<=10){
				beginPageIndex=1;
				endPageIndex=pageCount;
			}else{
			//总页数大于10，则显示当前页附近的10页
				beginPageIndex=currentPage-4;
				endPageIndex=currentPage+5;
				//当  前面的页码数量不足4个时，则显示前10个页码
				if(beginPageIndex<1){
					beginPageIndex=1;
					endPageIndex=10;				
				}
				//当  后面的页码数量不足5个时，则显示后10个页码
				if(endPageIndex>pageCount){
					endPageIndex=pageCount;
					beginPageIndex=pageCount-10+1;
				}
			}
			
		}
		
		
}
