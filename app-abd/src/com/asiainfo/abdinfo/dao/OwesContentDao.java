package com.asiainfo.abdinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.OwesContent;

public interface OwesContentDao {
	List<OwesContent> findbydayoct(@Param("staffcode")String staffcode,@Param("date") String date);
}
