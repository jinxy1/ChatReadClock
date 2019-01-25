package com.asiainfo.abdinfo.service;

import java.util.List;
import java.util.Map;

import com.asiainfo.abdinfo.po.ReadClock;
/** 首页点击封面获取书单 */
public interface linkageHomeService {
	public List<ReadClock>  getLinkage(Map map);
}
