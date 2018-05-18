package com.unioncom.cn.utils;

public class StringUtils {
	//处理空值
	public static String handleEmpty(String str) {
		return str == null ? "" : str;
	}
}
