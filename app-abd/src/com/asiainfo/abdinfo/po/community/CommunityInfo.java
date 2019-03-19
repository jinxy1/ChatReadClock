package com.asiainfo.abdinfo.po.community;

import java.io.Serializable;
import java.util.List;

import com.asiainfo.abdinfo.po.Personnel;

public class CommunityInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5877355756811325458L;
	private Integer id;
	private String typeName;
	private String infoTitle;
	private String infoContent;
	private String infoCurrentTime;
	private String infoSendStaffCode;
	private Personnel personnel;
	private List<String> communityImgInfo;
	private CommunityInfoRead communityInfoRead;
	private CommunityAcceptInfo acceptInfo;
	public CommunityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommunityInfo [id=" + id + ", typeName=" + typeName + ", infoTitle=" + infoTitle + ", infoContent="
				+ infoContent + ", infoCurrentTime=" + infoCurrentTime + ", infoSendStaffCode=" + infoSendStaffCode
				+ ", personnel=" + personnel + ", communityImgInfo=" + communityImgInfo + ", communityInfoRead="
				+ communityInfoRead + ", acceptInfo=" + acceptInfo + "]";
	}
	CommunityInfo(Integer id, String typeName, String infoTitle, String infoContent, String infoCurrentTime,
			String infoSendStaffCode, Personnel personnel, List<String> communityImgInfo,
			CommunityInfoRead communityInfoRead, CommunityAcceptInfo acceptInfo) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
		this.infoCurrentTime = infoCurrentTime;
		this.infoSendStaffCode = infoSendStaffCode;
		this.personnel = personnel;
		this.communityImgInfo = communityImgInfo;
		this.communityInfoRead = communityInfoRead;
		this.acceptInfo = acceptInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public String getInfoCurrentTime() {
		return infoCurrentTime;
	}
	public void setInfoCurrentTime(String infoCurrentTime) {
		this.infoCurrentTime = infoCurrentTime;
	}
	public String getInfoSendStaffCode() {
		return infoSendStaffCode;
	}
	public void setInfoSendStaffCode(String infoSendStaffCode) {
		this.infoSendStaffCode = infoSendStaffCode;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public List<String> getCommunityImgInfo() {
		return communityImgInfo;
	}
	public void setCommunityImgInfo(List<String> communityImgInfo) {
		this.communityImgInfo = communityImgInfo;
	}

	public CommunityInfoRead getCommunityInfoRead() {
		return communityInfoRead;
	}

	public void setCommunityInfoRead(CommunityInfoRead communityInfoRead) {
		this.communityInfoRead = communityInfoRead;
	}
	public CommunityAcceptInfo getAcceptInfo() {
		return acceptInfo;
	}
	public void setAcceptInfo(CommunityAcceptInfo acceptInfo) {
		this.acceptInfo = acceptInfo;
	}
	

}
