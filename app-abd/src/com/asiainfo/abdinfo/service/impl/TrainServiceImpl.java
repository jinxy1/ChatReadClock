package com.asiainfo.abdinfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.abdinfo.dao.ITrainDao;
import com.asiainfo.abdinfo.po.Train;
import com.asiainfo.abdinfo.service.ITrianService;

@Service
public class TrainServiceImpl implements ITrianService{
	
	@Resource
	private ITrainDao trainDao;
	
	@Override
	public List<Train> findTrain(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return trainDao.findTrain(map);
	}

	@Override
	public int updateTrain(Map<String, Object> map) {
		
		return trainDao.updateTrain(map);
	}

}
