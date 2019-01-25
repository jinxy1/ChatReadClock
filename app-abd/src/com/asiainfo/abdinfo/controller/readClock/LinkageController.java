package com.asiainfo.abdinfo.controller.readClock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.abdinfo.common.JsonUtils;
import com.asiainfo.abdinfo.common.ResponseUtils;
import com.asiainfo.abdinfo.po.ReadClock;
import com.asiainfo.abdinfo.service.linkageHomeService;

/** 首页点击封面获取书单 */
@Controller
public class LinkageController {

	@Autowired
	private linkageHomeService inkageHomeService;

	@RequestMapping(value = "Linkage.do")
	public void Linkage(HttpServletRequest request, HttpServletResponse response) {

		String staffCode = request.getParameter("staffCode");
		Map<String, String> map = new HashMap<String, String>();
		map.put("staffCode", staffCode);
		List<ReadClock> re = inkageHomeService.getLinkage(map);
		System.out.println(re);
		ResponseUtils.renderJson(response, JsonUtils.toJson(re));
	}

}
