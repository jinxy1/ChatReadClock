package com.asiainfo.abdinfo.po;

import java.io.Serializable;

public class Types implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4200926018033656275L;
	private Integer id;
	private String type;
	public Types() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Types(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
