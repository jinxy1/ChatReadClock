package com.asiainfo.abdinfo.po.community;

import java.io.Serializable;

public class CommunityInfoType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -511568257339936301L;
	private Integer id;
	private String typeName;
	private String typeImg;
	public CommunityInfoType() {
		super();
	}
	public CommunityInfoType(Integer id, String typeName, String typeImg) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.typeImg = typeImg;
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
	public String getTypeImg() {
		return typeImg;
	}
	public void setTypeImg(String typeImg) {
		this.typeImg = typeImg;
	}
	@Override
	public String toString() {
		return "MessageType [id=" + id + ", typeName=" + typeName + ", typeImg=" + typeImg + "]";
	}
	

}
