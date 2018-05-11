package com.unioncom.cn.service;

import java.util.Date;
import java.util.List;

import com.unioncom.cn.bean.LoginLog;

public interface LoginLogService {
	public List<LoginLog> getAll();

	public List<LoginLog> findByKeyWord(String key);

	public List<LoginLog> findByConditions(String key, String city, String sysname, Date beginTime, Date endTime);
}
