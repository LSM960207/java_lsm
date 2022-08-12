package kr.green.springtest.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; 
	private int perPageNum;
	private String search;
	private String searchType;

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		search = "";
		searchType = "all";
	}
	//getter and setter
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		/* 한 페이지에 컨텐츠 수를 0이상 100이하로 설정
		개발자 설정에 따라 100부분을 수정할 수 있음 */
		if(perPageNum <=0 || perPageNum > 100) {
			this.perPageNum = 10;
		}
		else
			this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
}