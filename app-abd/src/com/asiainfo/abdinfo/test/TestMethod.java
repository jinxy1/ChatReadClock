package com.asiainfo.abdinfo.test;


import org.junit.Test;

import com.asiainfo.abdinfo.common.EmojiUtil;
import com.vdurmont.emoji.EmojiParser;

public class TestMethod {
	
	@Test
	public void Test(){
		String content=EmojiUtil.onlyEmojiToUnicode("内容任杰@");
		System.out.println(content);
	}
	
	
	@Test
	public void Test1(){
		String str = "2019-02-08";
		String str1=str.trim().substring(8,10);
		
		System.out.println(Integer.parseInt(str1));
		
        

	}

}
