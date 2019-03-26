package com.asiainfo.abdinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.abdinfo.po.Community;
import com.asiainfo.abdinfo.po.FlowInfoAccapt;
import com.asiainfo.abdinfo.po.NewLoginBean.OtherAdd;

public interface CommunityDao {
	
	/**
	 * 查询所有的部门
	 * @return
	 */ 
	List<String> selectCommunityDep();
	
	
	int insertCommunit(Community community);
	
	
	void insertInfoAccept(List<FlowInfoAccapt> list );
	
	
	/**
	 * 插入圖片
	 */
	void insertInfoImage(@Param(value="infoId")Integer infoId,@Param(value="infoImg")String infoImg);
	
	
	/**
	 * 查询类型的名称
	 * @return
	 */
	List<String> selectTypeName();
	
	
	/**
	 * 插入其他
	 * @param otherAdd
	 */
	void insertOtherType(List<OtherAdd> otherAdd);
	
	
	/**
	 * 根据人员编码查询部门
	 * @return
	 */
//	List<Map<String, Object>> selectDepID(@Param(value="staffCode") String staffCode);
//	
//	
//	int selectLevelID(@Param(value="id") Integer id);

}





