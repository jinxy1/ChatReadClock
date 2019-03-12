package com.asiainfo.abdinfo.service;

import java.util.Map;

import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

public interface ICommunityService {
	public Map<String, Object> getCommunityMsType(User user,String typeName,PageBounds pb);/**获取社区信息类型*/
}
