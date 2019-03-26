package com.asiainfo.abdinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.Community;

public interface CommunityService {
	
	List<String> getCommunityDep();
	
	
	void insertCommunits(Community community);
	
	
	/**
	 * 插入圖片
	 * @param infoId
	 * @param infoImg
	 */
	void insertInfoImage(Integer infoId,String infoImg);
	
	
	List<String>getTypeName(String staffCode);
	
	
	/**
	 * 根据人员编码查询
	 * @param staffCode
	 * @return
	 */
	List<String> getDepID(String staffCode);
	
	
	
	public void  getOnid(String department);
	
	//根据部门查询部门id
	int getDepdepId( String dep,List<String> list);

}
