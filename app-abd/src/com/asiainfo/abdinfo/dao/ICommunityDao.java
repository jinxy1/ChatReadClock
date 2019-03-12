package com.asiainfo.abdinfo.dao;
/**社区内容接口*/

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.po.community.CommunityInfo;
import com.asiainfo.abdinfo.po.community.CommunityInfoType;

public interface ICommunityDao {
	
	public List<CommunityInfoType> getCommunityMsgType();/**获取社区信息类型*/
	public List<CommunityInfo> getCommunityMsg(
			@Param("user") User user,
			@Param("typeName") String typeName
			);/**获取社区信息*/
	
}
