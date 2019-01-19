package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.Massage;
import com.asiainfo.abdinfo.po.PageBean;
import com.asiainfo.abdinfo.utils.mybatis.paginator.domain.PageBounds;

public interface IMassageService {
	
	public PageBean findMassage(Map<String, Object> map,PageBounds pb);//查询所有信息
	public Integer findCount(Map<String, Object> map);//查询信息的数量
	public int updateMassage(Map<String, Object> map);//更新信息的状态

}
