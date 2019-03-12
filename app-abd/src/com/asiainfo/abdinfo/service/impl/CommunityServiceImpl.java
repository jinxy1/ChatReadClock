package com.asiainfo.abdinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.ICommunityDao;
import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.po.community.CommunityInfo;
import com.asiainfo.abdinfo.po.community.CommunityInfoType;
import com.asiainfo.abdinfo.service.ICommunityService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;
import com.github.pagehelper.PageHelper;

@Service
public class CommunityServiceImpl implements ICommunityService{
	
	@Autowired
	private ICommunityDao icommunityDao;
	
	@Override
	public Map<String, Object> getCommunityMsType(User user,String typeName,PageBounds pb) {
		List<CommunityInfoType> communityInfoTypes=icommunityDao.getCommunityMsgType();
		PageHelper.startPage(pb.getPage(), pb.getLimit());
		List<CommunityInfo> communityInfos=icommunityDao.getCommunityMsg(user,typeName);
		PageBean<CommunityInfo>  pageBean=new PageBean<CommunityInfo>(communityInfos);
		Map<String, Object> map =new HashMap<>();
		map.put("communityInfoTypes", communityInfoTypes);
		map.put("pageBean", pageBean);
		return map;
	}

}
