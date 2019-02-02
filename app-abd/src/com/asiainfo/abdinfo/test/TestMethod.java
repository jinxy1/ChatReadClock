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
		String str = "";
        System.out.println("原始字符为：\n" + str);

        System.out.println("to aliases 之后：");
        System.out.println(EmojiParser.parseToAliases(str));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.PARSE));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.REMOVE));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.IGNORE));

	}

}
