package com.asiainfo.abdinfo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.ISixDiligenceDao;
import com.asiainfo.abdinfo.po.Menus;
import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.po.SixDiligence;
import com.asiainfo.abdinfo.po.SixList;
import com.asiainfo.abdinfo.service.ISixDiligenceService;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;
import com.github.pagehelper.PageHelper;

@Service
public class SixDiligenceServiceImpl implements ISixDiligenceService{
	
	@Resource
	private ISixDiligenceDao sixDiligenceDao;
	
	/**获取个人当天工作总结和感想、感恩、善行、反省*/
	@Override
	public Map<String, Object> findSixDiligence(Map<String, Object> map) {
		System.out.println(map);
		List<SixDiligence> sixDiligence=sixDiligenceDao.findSixDiligence(map);  //今日反思 n
		List<SixDiligence> tips=sixDiligenceDao.findTips(map);        //感恩的人n
		List<SixDiligence> readFeeling=sixDiligenceDao.findReadFeeling(map);  //读书感悟1
		List<SixDiligence> works=sixDiligenceDao.findWork(map);   //工作z
		/*List<Works> worksSix=new ArrayList<Works>();
		if (works.size()!=0) {
			worksSix=works.get(0).getWorks();//获取工作总结
		}
		List<String> workStr=new ArrayList<String>();
		List<Integer> workID=new ArrayList<Integer>();
		for (Works works2 : worksSix) {
			workStr.add(works2.getWork());*//**将工作总结的内容转换成字符串数组*//*
			workID.add(works2.getId());*//**将每个工作总结的唯一id存到数组中，用于删除单个工作总结*//*
		}*/
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("sixDiligence",sixDiligence);
		data.put("tips",tips);
		data.put("readFeeling", readFeeling);
		data.put("works", works);
		return data;
	}
	
	/**查询自主内容*/
	@Override
	public List<Menus> findCustomcontent(Map<String, Object> map) {
		return sixDiligenceDao.findCustomcontent(map);
	}
	
	//我的页面查找读书感悟
	@Override
	public PageBean<SixDiligence> findReadingFeeling(Map<String, Object> map,PageBounds pb) {
		PageHelper.startPage(pb.getPage(), pb.getLimit());
		List<SixDiligence> readFeeling=sixDiligenceDao.findReadFeeling(map);  //读书感悟
		PageBean<SixDiligence>  pageBean  = new PageBean<SixDiligence>(readFeeling);
		return pageBean;
	}
	
	/**在我的查找工作总结，日感想，善行，感恩，反省的内容*/
	@Override
	public PageBean findTips(Map<String, Object> map, PageBounds pb) {
		PageHelper.startPage(pb.getPage(), pb.getLimit());
		List<SixDiligence> readFeeling=sixDiligenceDao.findReadFeeling(map);/**读书感悟*/
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String date=null;
		System.out.println(readFeeling.get(0).getCeshi());
		for(int i=0;i<readFeeling.size();i++){
			Date day=readFeeling.get(i).getDate();
			date=df.format(day);
			map.put("date", date);
			List<SixDiligence> findSixDiligence=sixDiligenceDao.findSixDiligence(map);
			readFeeling.get(i).setMenus(sixDiligenceDao.findMenus(map));
			readFeeling.get(i).setWorks(sixDiligenceDao.findworks(map));
			readFeeling.get(i).setCustomContent(sixDiligenceDao.findCustomcontent(map));
			if (findSixDiligence.size()!=0) {
				readFeeling.get(i).setTypes(findSixDiligence.get(0).getTypes());
			}
		}
		
		PageBean  pageBean  = new PageBean(readFeeling);
		return pageBean;
	}
	/**查询部门或者事业部的日总结、感想等内容*/
	@Override
	public Map<String, Object> findbydaydiligence(String staffcode, String date, String bumen) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("staffCode", staffcode);
		map.put("date", date);
		map.put("bumen", bumen);
		List<String> staffCodes=sixDiligenceDao.findStaffCode(map);
		map.put("staffCodes", staffCodes);
		List<SixList> sixLists=sixDiligenceDao.find(map);
		System.out.println(sixLists.size());
		map.put("sixLists", sixLists);
		return map;
	}

	
}
