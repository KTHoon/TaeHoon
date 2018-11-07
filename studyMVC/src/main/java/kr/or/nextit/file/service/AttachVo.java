package kr.or.nextit.file.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class AttachVo implements Serializable {

	private String refSeqNo;
	private int seqNo;
	private String userId;
	private String fileName;

	private String savePath;
	private String saveName;
	private String saveContentType;
	private long saveSize;

	// === 여기부터는 비지니스 로직상 처리하기 위한 객체
	private String serviceType;
	private int fileDownCnt;

	private String usrIp;
	private String delAt;
	private String regUser;
	private String regDt;
	private String updUser;
	private String updDt;

	public String getRefSeqNo() {
		return refSeqNo;
	}

	public void setRefSeqNo(String refSeqNo) {
		this.refSeqNo = refSeqNo;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileDownCnt() {
		return fileDownCnt;
	}

	public void setFileDownCnt(int fileDownCnt) {
		this.fileDownCnt = fileDownCnt;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getSaveContentType() {
		return saveContentType;
	}

	public void setSaveContentType(String saveContentType) {
		this.saveContentType = saveContentType;
	}

	public long getSaveSize() {
		return saveSize;
	}

	public void setSaveSize(long saveSize) {
		this.saveSize = saveSize;
	}

	public String getUsrIp() {
		return usrIp;
	}

	public void setUsrIp(String usrIp) {
		this.usrIp = usrIp;
	}

	public String getDelAt() {
		return delAt;
	}

	public void setDelAt(String delAt) {
		this.delAt = delAt;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
