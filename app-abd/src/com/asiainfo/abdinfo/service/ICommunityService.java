package com.asiainfo.abdinfo.service;

import java.util.Map;

import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.po.community.CommunityInfoRead;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

public interface ICommunityService {
	
	/**获取社区信息类型*/
	public Map<String, Object> getCommunityMsType(User user,String typeName,PageBounds pb,String infoTitle);
	
	/**更改未读信息的状态*/
	public Integer changeReadStatus(CommunityInfoRead communityInfoRead);
	
	/**更改未读信息时像flow_info_read表中插入一条信息，在更改未读信息判断是否已经插入此信息的状态*/
	public Integer getReadCount(CommunityInfoRead communityInfoRead);
	
	/**获取未读信息数量*/
	public Integer getunlessMsgCount(User user);
}
