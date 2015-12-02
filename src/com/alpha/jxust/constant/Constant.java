package com.alpha.jxust.constant;

/**
 * 定义一些常量的类
 * @author bing
 */
public class Constant 
{
	//Button的标识
	public static final int BTN_FLAG_NEWS= 0x01;
	public static final int BTN_FLAG_SCHOOLFELLOW = 0x01 << 1;
	public static final int BTN_FLAG_TEXTBOOK = 0x01 << 2;
	public static final int BTN_FLAG_MORE = 0x01 << 3;
	
	//Fragment的标识
	public static final String FRAGMENT_FLAG_NEWS = "新闻"; 
	public static final String FRAGMENT_FLAG_SCHOOLFELLOW = "校友"; 
	public static final String FRAGMENT_FLAG_TEXTBOOK = "教材"; 
	public static final String FRAGMENT_FLAG_MORE = "更多"; 
	
	public static final String FRAGMENT_FLAG_SIMPLE = "simple";
}
