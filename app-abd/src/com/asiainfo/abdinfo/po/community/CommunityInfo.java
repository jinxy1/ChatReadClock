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
	private Integer infoTypeId;
	private String infoTitle;
	private String infoContent;
	private String infoCurrentTime;
	private String infoSendStaffCode;
	private Personnel personnel;
	private List<String> communityImgInfo;
	public CommunityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommunityInfo [id=" + id + ", infoTypeId=" + infoTypeId + ", infoTitle=" + infoTitle + ", infoContent="
				+ infoContent + ", infoCurrentTime=" + infoCurrentTime + ", infoSendStaffCode=" + infoSendStaffCode
				+ ", personnel=" + personnel + "]";
	}
	public CommunityInfo(Integer id, Integer infoTypeId, String infoTitle, String infoContent, String infoCurrentTime,
			String infoSendStaffCode, Personnel personnel, List<String> communityImgInfo) {
		super();
		this.id = id;
		this.infoTypeId = infoTypeId;
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
		this.infoCurrentTime = infoCurrentTime;
		this.infoSendStaffCode = infoSendStaffCode;
		this.personnel = personnel;
		this.communityImgInfo = communityImgInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInfoTypeId() {
		return infoTypeId;
	}
	public void setInfoTypeId(Integer infoTypeId) {
		this.infoTypeId = infoTypeId;
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
	

}
