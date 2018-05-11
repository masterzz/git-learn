package com.unioncom.cn.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unioncom.cn.bean.LoginLog;
import com.unioncom.cn.bean.SystemLogFile;

public interface SystemLogFileRepository extends JpaRepository<SystemLogFile, Long>{
	//根据日期查找
//	List<SystemLogFile> findByLoginTimeBetween(Date startDate, Date endDate);
}
