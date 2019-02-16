package com.asiainfo.abdinfo.po;

import java.io.Serializable;
import java.util.List;

public class Calendar implements Serializable{

	private static final long serialVersionUID = -8772031787635566584L;
	
	private String project;
	
	private List<String> contents;
	
	private String icon;
	
	

	public Calendar() {
		super();
	}

	public Calendar(String project, List<String> contents, String icon) {
		super();
		this.project = project;
		this.contents = contents;
		this.icon = icon;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Calendar [project=" + project + ", contents=" + contents + ", icon=" + icon + "]";
	}


   

	
	
	
	

	
}
