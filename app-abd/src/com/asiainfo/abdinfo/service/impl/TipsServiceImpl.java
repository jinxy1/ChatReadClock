package com.asiainfo.abdinfo.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.asiainfo.abdinfo.dao.ISixDiligenceDao;
import com.asiainfo.abdinfo.dao.ITipsDao;
import com.asiainfo.abdinfo.po.Menus;
import com.asiainfo.abdinfo.po.SixDiligence;
import com.asiainfo.abdinfo.po.User;
import com.asiainfo.abdinfo.service.ITipsService;

@Service("ITipsService")
public class TipsServiceImpl implements ITipsService{
	
	@Resource
	private ITipsDao tipsDao;
	
	@Resource
	private ISixDiligenceDao sixDiligenceDao;
	
	@Override
	public Map<String, Integer> addTipsDailyfeeling(Map<String, Object> map) {
		
		List<SixDiligence> sixDiligences=sixDiligenceDao.findSixDiligence(map);
		JSONArray tipsArray=JSONArray.parseArray((String)map.get("tips"));
		JSONArray jsonArray=JSONArray.parseArray((String)map.get("menus"));
		String customStr=(String)map.get("customcontent");
		int num=0;
		int num1=0;
		int num2=0;
		Menus menusCustom=(Menus)JSON.parseObject(customStr,Menus.class);
		map.put("customcontent", menusCustom.getContent());
		map.put("customtype", menusCustom.getType());
		num2=tipsDao.updateCustomContent(map);
		if (sixDiligences.size()==0) {
			for (Object object : tipsArray) {
				String str=object.toString();
				Menus menus=(Menus)JSON.parseObject(str,Menus.class);
				String type=menus.getType();
				String content=menus.getContent();
				map.put("type", type);
				map.put("content", content);
				num=tipsDao.addTipsDailyfeeling(map);//添加今日感想，今日善行，今日反省，感恩其他
			};
		}else {
			for (Object object : tipsArray) {
				String str=object.toString();
				Menus menus=(Menus)JSON.parseObject(str,Menus.class);
				String type=menus.getType();
				String content=menus.getContent();
				map.put("type", type);
				map.put("content", content);
				num=tipsDao.updateTipsDailyfeeling(map);
				
			};
		}
		tipsDao.deleteOwes_content(map);
		for (Object object : jsonArray) {
			String str=object.toString();
			System.out.println(str);
			Menus menus=(Menus)JSON.parseObject(str,Menus.class);
			String per=menus.getPers();
			String detail=menus.getDetail();
			Integer id=menus.getId();
			String staffCodeOther=menus.getStaffCodeOther();
			map.put("per", per);
			map.put("detail", detail);
			map.put("id", id);
			map.put("staffCodeOther", staffCodeOther);
			num1=tipsDao.addTipsOwes_content(map);
		};
		
		//更新感恩人功能
		/*else {
			for (Object object : jsonArray) {
				String str=object.toString();
				Menus menus=(Menus)JSON.parseObject(str,Menus.class);
				String per=menus.getPers();
				String detail=menus.getDetail();
				Integer id=menus.getId();
				String staffCodeOther=menus.getStaffCodeOther();
				map.put("per", per);
				map.put("detail", detail);
				map.put("id", id);
				map.put("staffCodeOther", staffCodeOther);
				num1=tipsDao.updateTipsOwes_content(map);
			};
		}*/
		
		Map<String, Integer> numMap=new HashMap<String, Integer>();
		numMap.put("num", num);
		numMap.put("num1", num1);
		numMap.put("num2", num2);
		return numMap;
	}
	/**查询所有人的姓名信息用于模糊查询*/
	@Override
	public List<User> findTips(Map<String, Object> map) {
		return tipsDao.findTips(map);
	}
	@Override
	public int deleteTipsOwes_content(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tipsDao.deleteTipsOwes_content(map);
	}

	

	


}
