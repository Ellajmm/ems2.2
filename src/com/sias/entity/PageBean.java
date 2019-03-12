package com.sias.entity;

import java.io.Serializable;

public class PageBean implements Serializable {
 private int pageNo;//ҳ��
 private int pageCount=3;//ÿҳչʾ��Ϣ��
 private int pageTotal;//����Ϣ����
 
 //��pageNoҳ����ʼ��
 public int getBegin(){
	 return 1+(pageNo-1)*pageCount; 
 }
 //��pageNoҳ�Ľ�����
 public int getEnd(){
	 return pageNo*pageCount;
 }
 //��ȡ��ҳ��
 public int getPageSum(){
	 if(pageTotal%pageCount == 0){
		 return pageTotal/pageCount;
	 }
	 return pageTotal/pageCount+1;
	 
 }
public int getPageNo() {
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
public int getPageTotal() {
	return pageTotal;
}
public void setPageTotal(int pageTotal) {
	this.pageTotal = pageTotal;
}
public PageBean() {
	super();
	// TODO Auto-generated constructor stub
}
public PageBean(int pageNo, int pageCount, int pageTotal) {
	super();
	this.pageNo = pageNo;
	this.pageCount = pageCount;
	this.pageTotal = pageTotal;
}
@Override
public String toString() {
	return "PageBean [pageNo=" + pageNo + ", pageCount=" + pageCount
			+ ", pageTotal=" + pageTotal + "]";
}
 
}
