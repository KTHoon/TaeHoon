package kr.or.nextit.member.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MemberVo implements Serializable {

	private int num;
	private String seqNo;
	private String memId;
	private String memPwd;
	private String memName;
	private String memPhone;
	private String memEmail;
	private String regDate;

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemName() {
		return memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public int getNum() {
		return num;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

}
