package com.asiainfo.abdinfo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.CommunityDao;
import com.asiainfo.abdinfo.po.Community;
import com.asiainfo.abdinfo.po.FlowInfoAccapt;
import com.asiainfo.abdinfo.service.CommunityService;

@Service("communityServiceImple")
public class CommunityServiceImple implements CommunityService {

	@Autowired
	private CommunityDao communityDao;
 
	@Override
	public List<String> getCommunityDep() {

		return communityDao.selectCommunityDep();
	}

	@Override
	public void insertCommunits(Community community) {
		System.out.println(community);
		// 插入主表
		communityDao.insertCommunit(community);
		// 插入谁可以看
		System.out.println(community.getArrData());

		// 將List集合中的接收信息
		List<FlowInfoAccapt> list = new ArrayList<FlowInfoAccapt>();
		for (int i = 0; i < community.getArrData().size(); i++) {
			FlowInfoAccapt flowInfoAccapt = new FlowInfoAccapt();
			flowInfoAccapt.setInfoid(community.getId());
			flowInfoAccapt.setInfoAcceptName(community.getArrData().get(i));
			list.add(flowInfoAccapt);
		}

		communityDao.insertInfoAccept(list);

		// 将其他信息插入到数据库中
		if (community.getArrType() != null) {
			for (int i = 0; i < community.getArrType().size(); i++) {
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
	public List<String> getTypeName(String staffCode) {
		return communityDao.selectTypeName(staffCode);
	}

	// @Override
	public List<String> getDepID(String staffCode) {
		// 判断这个人的部门ID
		int depId = communityDao.selectDepID(staffCode);
		// 用来存储该人全部以上的部门
		List<String> list = new ArrayList<String>();
		while (depId != 0) {
			Map<String, String> a = communityDao.selectLevelID(depId);
			list.add(String.valueOf(a.get("dep")));
			depId = Integer.parseInt(String.valueOf(a.get("levelid")));
		}
		return list;
	}

	@Override
	public void getOnid(String department) {
		int depsId = communityDao.selectOnid(department);
		while (depsId != 0) {
		}
	}

	// 根据部门查询部门id
//	@Override
//	public int getDepdepId(String dep, List<String> list) {

//		long beginTime = System.currentTimeMillis();
//		// step1 根据部门查询部门ID
//		int depID = communityDao.selectDepdepId(dep);
//		System.out.println(depID);
//
//		// step3 先跟数组中部门比较
//		if (list.size() != 0) {
//
//		
//		//	boolean flagDepBut = true; // true 表示下级没有相同的 false 表示下级有相同的
//
//			// step3-1 查询输入部门以上是否有部门  若有則不添加   若沒有則查看下面
//			List<String> depAll=new ArrayList<String>();
//			while (depID != 0) {
//				Map<String, String> a = communityDao.selectLevelID(depID);
//				depAll.add(String.valueOf(a.get("dep")));
//			}
//			System.out.println(depAll);
			
//			boolean flag = true; // true 表示上级没有相同的；false 表示有相同的
			
			
//			for(int i=0;i<list.size();i++){
//				for(int j=0;j<depAll.size();j++){
//					if(list.get(i)==depAll.get(j)){
//						flag=false;
//						break;
//					}
//				}
//				}
			
			// step3-2-1
//			List<String> deps = communityDao.selectDepBoolean(depID); // 根据部门id查询他所有的下级部门
//			System.out.println(deps);
//			}

			
//			for (int i = 0; i < depArr.size(); i++) {
//				// step3-2 查询输入部门以下的部门
//				// step3-2-1 deps.size()==0 表示没有下级部门
//				if (deps.size() != 0) {
//					for (int j = 0; j < deps.size(); j++) {
//						if (depArr.get(i).compareTo(deps.get(j)) == 0) {
//							flagDepBut = false;
//							break;
//						}
//					}
//				}
//
//				if (flag && flagDepBut) { // 表示上级跟下级都没有相同的
//					list.add(dep);
//				} else if (flag && !flagDepBut) { // 表示上级没有相同的 下级有
//					// 先把下级的删除
//
//				}
//
//			}
//
//		}

		// step4跟数组中的员工编码做比较
		// if(digitalArr.size()!=0){
		//
		// }
//		System.out.println(list);
//
//		long endTime = System.currentTimeMillis();
//		System.out.println("输入部门所用时长为" + (endTime - beginTime));
//		return 0;
//	}

}
