package com.asiainfo.abdinfo.controller.community;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.asiainfo.abdinfo.po.Community;
import com.asiainfo.abdinfo.service.impl.CommunityServiceImple;

@Controller
public class CommunityController {

	@Autowired
	private CommunityServiceImple communityServiceImple;

	@ResponseBody
	@RequestMapping(value = "communityDep.do", method = RequestMethod.POST)
	public List<String> CommunityDep() {
		return communityServiceImple.getCommunityDep();
	}

	@ResponseBody
	@RequestMapping(value = "communityDataInsert.do", method = RequestMethod.POST)
	public int communityDataDep(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "staffCode") String staffCode, @RequestParam(value = "community") String community) {
		Community con = JSON.parseObject(community, Community.class);
		System.out.println(con);
		con.setStaffCode(staffCode);
		communityServiceImple.insertCommunits(con);
		System.out.println(con.getId());
		return con.getId(); // 返回主鍵
	}

	@ResponseBody
	@RequestMapping(value = "communityImgInsert.do", method = RequestMethod.POST)
	public String communityInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "infoId") Integer infoId) throws IllegalStateException, IOException {

		System.out.println(infoId);

		if (file != null) { // 判断文件是否为空
			String path = ""; // 文件的路径
			String type = ""; // 文件类型
			String fileName = file.getOriginalFilename(); // 文件原名称
			System.out.println("原文件的名称为" + fileName);
			// DSC_0154 - 副本.JPG
			// 判断文件的类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (type != null) {
				if ("PNG".equals(type.toUpperCase()) || "GIF".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目实际运行发布的路径
					String realPath = request.getSession().getServletContext().getRealPath("/");
					System.out.println(realPath);

					// 自定义文件的名字
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;

					System.out.println(trueFileName);
					File fie = new File(realPath + "onloadImg");
					if(!fie.exists()){
						fie.mkdirs();
					}

					path = realPath + File.separator + "onloadImg" + File.separator + trueFileName;
					System.out.println("存放图片文件的路径:" + path);
					// 转存文件到指定的路径
					file.transferTo(new File(path));
					communityServiceImple.insertInfoImage(infoId, trueFileName);

				}
			} else {
				System.out.println("文件类型为空");
			}
		} else {
			System.out.println("文件为空");
		}

		return "001";
	}


	@ResponseBody
	@RequestMapping(value = "typeName.do", method = RequestMethod.POST)
    public List<String> typeName(){
    	return communityServiceImple.getTypeName();
    }


}
