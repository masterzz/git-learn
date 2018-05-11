package com.unioncom.cn.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unioncom.cn.bean.UserLog;

public interface UserLogRepository extends JpaRepository<UserLog, Long>{
}
