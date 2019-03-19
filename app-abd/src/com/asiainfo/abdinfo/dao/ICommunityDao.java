package com.asiainfo.abdinfo.dao;
/**社区内容接口*/

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.po.community.CommunityInfo;
import com.asiainfo.abdinfo.po.community.CommunityInfoRead;
import com.asiainfo.abdinfo.po.community.CommunityInfoType;

public interface ICommunityDao {
	
	public List<CommunityInfoType> getCommunityMsgType();/**获取社区信息类型*/
	public List<CommunityInfo> getCommunityMsg(
			@Param("user") User user,
			@Param("typeName") String typeName,
			@Param("infoTitle") String infoTitle
			);/**获取社区信息*/
	
	public Integer getReadInfo(CommunityInfoRead communityInfoRead);
	public Integer addReadInfo(CommunityInfoRead communityInfoRead);
	public List<CommunityInfoType> getUnlessMsgCount(@Param("user") User user);
	
}
