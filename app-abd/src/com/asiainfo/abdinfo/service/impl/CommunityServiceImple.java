package com.asiainfo.abdinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.CommunityDao;
import com.asiainfo.abdinfo.po.Community;
import com.asiainfo.abdinfo.po.FlowInfoAccapt;
import com.asiainfo.abdinfo.service.CommunityService;

@Service("communityServiceImple")
public class CommunityServiceImple implements CommunityService{
	
	@Autowired
	private CommunityDao communityDao;
 
	@Override
	public List<String> getCommunityDep() {
		
		return communityDao.selectCommunityDep();
	}

	@Override
	public void insertCommunits(Community community) {
		System.out.println(community);
		//插入主表
		communityDao.insertCommunit(community);
		//插入谁可以看
		System.out.println(community.getArrData());
		
		//將List集合中的接收信息
		List<FlowInfoAccapt> list=new ArrayList<FlowInfoAccapt>();
		for(int i=0;i<community.getArrData().size();i++){
			FlowInfoAccapt flowInfoAccapt=new FlowInfoAccapt();
			flowInfoAccapt.setInfoid(community.getId());
			flowInfoAccapt.setInfoAcceptName(community.getArrData().get(i));
			list.add(flowInfoAccapt);
		}
	
		communityDao.insertInfoAccept(list);
		
		//将其他信息插入到数据库中
		if(community.getArrType()!=null){
			for(int i=0;i<community.getArrType().size();i++){
				community.getArrType().get(i).setId(community.getId());
				System.out.println(community);
				communityDao.insertOtherType(community.getArrType());
			}
		}
	}

	@Override
	public void insertInfoImage(Integer infoId, String infoImg) {
		communityDao.insertInfoImage(infoId, infoImg);
		
	}

	/**
	 * 查询类型的名称
	 */
	@Override
	public List<String> getTypeName() {
		return communityDao.selectTypeName();
	}

//	@Override
//	public void getDepID(String staffCode) {
		//判断这个人的部门ID
//		List<Map> depId=communityDao.selectDepID(staffCode);
//		System.out.println(depId);
//		
//		int a=0;
//		while(!a){
//			communityDao.selectLevelID(depId);
//		}
//		System.out.println(communityDao.selectDepID(staffCode));
		
//	}	
	
	
}



