package com.wom.service.model;

public class PageVo {

	private int offSet=0;
	private int page=1;
	private int pageSize=5;
	public int getOffSet() {
		return (page-1)*pageSize;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

    @Override
    public String toString() {
        return "PageVo{" +
                "offSet=" + offSet +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
