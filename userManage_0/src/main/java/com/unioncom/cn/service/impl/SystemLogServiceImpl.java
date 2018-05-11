package com.unioncom.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unioncom.cn.Dao.SystemLogRepository;
import com.unioncom.cn.bean.SystemLog;
import com.unioncom.cn.service.SystemLogService;

@Service
public class SystemLogServiceImpl implements SystemLogService {
	@Autowired
	SystemLogRepository logFileRepository;

	@Override
	public List<SystemLog> getAll() {
		return logFileRepository.findAll();
	}
}
