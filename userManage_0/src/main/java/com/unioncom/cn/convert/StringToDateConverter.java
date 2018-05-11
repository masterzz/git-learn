package com.unioncom.cn.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import ch.qos.logback.core.util.DatePatternToRegexUtil;

public class StringToDateConverter implements Converter<String, Date> {
	private String datePattern;

	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormate = new SimpleDateFormat(datePattern);
		try {
			return dateFormate.parse(source);
		} catch (Exception e) {
		}
		
		return null;
	}

}
