package com.asiainfo.abdinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.Announcement;

public interface AnoucemtDao {
	List<Announcement> nowdaytitle(@Param("nowday")String nowday);
}
