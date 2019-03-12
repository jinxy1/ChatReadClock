package com.asiainfo.abdinfo.po.community;

import java.io.Serializable;

public class CommunityAcceptInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3111371907176455927L;
	private Integer id;
	private Integer infoId;
	private String infoAcceptType;
	private String infoAcceptName;
	public CommunityAcceptInfo(Integer id, Integer infoId, String infoAcceptType, String infoAcceptName) {
		super();
		this.id = id;
		this.infoId = infoId;
		this.infoAcceptType = infoAcceptType;
		this.infoAcceptName = infoAcceptName;
	}
	public CommunityAcceptInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommunityAcceptInfo [id=" + id + ", infoId=" + infoId + ", infoAcceptType=" + infoAcceptType
				+ ", infoAcceptName=" + infoAcceptName + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getInfoAcceptType() {
		return infoAcceptType;
	}
	public void setInfoAcceptType(String infoAcceptType) {
		this.infoAcceptType = infoAcceptType;
	}
	public String getInfoAcceptName() {
		return infoAcceptName;
	}
	public void setInfoAcceptName(String infoAcceptName) {
		this.infoAcceptName = infoAcceptName;
	}
}
