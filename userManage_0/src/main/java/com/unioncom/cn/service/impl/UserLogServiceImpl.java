package com.unioncom.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unioncom.cn.Dao.UserLogRepository;
import com.unioncom.cn.bean.UserLog;
import com.unioncom.cn.service.UserLogService;

@Service
public class UserLogServiceImpl implements UserLogService {
	@Autowired
	UserLogRepository userLogRepository;

	@Override
	public List<UserLog> getAll() {
		return userLogRepository.findAll();
	}
}
