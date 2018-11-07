package kr.or.nextit.member.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import kr.or.nextit.com.utils.PagingVo;

public class MemberSearchVo extends PagingVo {

	public String searchType;
	public String searchText;
	
	public String memId;
	
	public String getMemId() {
		return memId;
	}
	public String getSearchText() {
		return searchText;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
