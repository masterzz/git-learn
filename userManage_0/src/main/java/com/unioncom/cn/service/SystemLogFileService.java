package com.unioncom.cn.service;

import java.util.List;
import com.unioncom.cn.bean.SystemLogFile;

public interface SystemLogFileService {
	public List<SystemLogFile> getAll();

	public void save(SystemLogFile systemLogFile);
}
