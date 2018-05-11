package com.unioncom.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unioncom.cn.Dao.SystemLogFileRepository;
import com.unioncom.cn.bean.SystemLogFile;
import com.unioncom.cn.service.SystemLogFileService;

@Service
public class SystemLogFileServiceImpl implements SystemLogFileService {
	@Autowired()
	SystemLogFileRepository systemLogFileRepository;

	@Override
	public List<SystemLogFile> getAll() {
		return systemLogFileRepository.findAll();
	}

	@Override
	public void save(SystemLogFile systemLogFile) {
		systemLogFileRepository.save(systemLogFile);
	}

}
