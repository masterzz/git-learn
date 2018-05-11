package com.unioncom.cn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unioncom.cn.bean.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByUsernameAndPassword(String username, String password);
	//根据日期查找
//	List<SystemLogFile> findByLoginTimeBetween(Date startDate, Date endDate);

	List<User> findByUsername(String username);
}
