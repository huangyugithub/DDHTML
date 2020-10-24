package com.baizhi.empty;

public class Page {
	private int pageNumber;  //页号，页数
	private int pageSize;    //每页展示条数
	private int totalPage;   //总页数
	private int totalCount;  //总条数
	private int firstCount;  //每页起始条数
	private int lastCount;   //每页结束条数
	
	//获取每页起始条数
	public int getFirstCount() {
		return firstCount;
	}
//	public void setFirstCount(int firstCount) {
//		this.firstCount = firstCount;
//	}
	//获取每页结束条数
	public int getLastCount() {
		return lastCount;
	}
//	public void setLastCount(int lastCount) {
//		this.lastCount = lastCount;
//	}
	//不传页数和每页展示条数，默认设置：每页展示3条商品数据，页数为1，——>由struts。xml中设置
	public Page() {
		pageSize = 3;
	}
	public Page(int pageNumber,int pageSize){
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public Page(int pageNumber){
		this(pageNumber,3);
//		this.pageNumber = pageNumber;
//		this.pageSize = 3;
	}
	

	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	//总页数不能人为设置
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//设置总页数   在查询总条数时，可计算出总页数，设置总页数
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		//设置每页起始条数
		this.firstCount = (pageNumber-1)*pageSize+1;
		//设置每页结束条数
		lastCount = pageNumber*pageSize;
		
	}
	
	
}
