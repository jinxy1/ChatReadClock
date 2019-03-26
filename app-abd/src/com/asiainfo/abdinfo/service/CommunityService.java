package com.asiainfo.abdinfo.service;

import java.util.List;

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
	
	
	List<String> getTypeName();
	
	
	/**
	 * 根据人员编码查询
	 * @param staffCode
	 * @return
	 */
//	void getDepID(String staffCode);

}
