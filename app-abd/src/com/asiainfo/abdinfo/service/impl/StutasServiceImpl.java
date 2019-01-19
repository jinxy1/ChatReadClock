package com.asiainfo.abdinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.IStutasDao;
import com.asiainfo.abdinfo.po.NewLoginBean.ListAllFeeling;
import com.asiainfo.abdinfo.service.IStutasService;
@Service("IStutasService")
public class StutasServiceImpl implements IStutasService{
	
	@Autowired
	private IStutasDao stutaDao;
	
	@Override
	public int addStutas(ListAllFeeling listAllFeeling) {

		List<Integer> listEnshrine=stutaDao.selectEnshrine(listAllFeeling);
		List<Integer> listFabulous=stutaDao.selectFabulous(listAllFeeling);
		List<Integer> listPraise=stutaDao.selectPraise(listAllFeeling);
		if (listAllFeeling.getPraise()==null) {
			listAllFeeling.setPraise("0");
		}
		if (listAllFeeling.getEnshrine()==null) {
			listAllFeeling.setEnshrine("0");
		}
		if (listAllFeeling.getFabulous()==null) {
			listAllFeeling.setFabulous("0");
		}
		
		
		if (listAllFeeling.getPraise().equals("1")) {
			if (!listPraise.contains(listAllFeeling.getId())) {
				stutaDao.addPraise(listAllFeeling);
			}
		}else {
			stutaDao.deletePraise(listAllFeeling);
		}
		if (listAllFeeling.getFabulous().equals("1")) {
			if (!listFabulous.contains(listAllFeeling.getId())) {
				stutaDao.addFabulous(listAllFeeling);
			}
		}else {
			stutaDao.deleteFabulous(listAllFeeling);
		}
		if (listAllFeeling.getEnshrine().equals("1")) {
			if (!listEnshrine.contains(listAllFeeling.getId())) {//判断list集合中是否存在某个值
				stutaDao.addEnshrine(listAllFeeling);
			}
		}else{
			stutaDao.deleteEnshrine(listAllFeeling);
		}
		return 1;
	}
	
	@Override
	public List<ListAllFeeling> selectEnshrines(String staffCode) {
		// TODO Auto-generated method stub
		return stutaDao.selectEnshrines(staffCode);
	}

	@Override
	public int deleteEnshrineById(Map<String, Object> map) {
		
		return stutaDao.deleteEnshrineById(map);
	}

	@Override
	public Integer selectFabulousNum(Map<String, Object> map) {
		
		return stutaDao.selectFabulousNum(map);
	}

}
