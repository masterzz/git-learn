package com.unioncom.cn.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unioncom.cn.bean.LoginLog;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long>{
	@Query("select u from LoginLog u where u.city like %?1%")
	List<LoginLog> findByCityLike(String city);
	@Query("select u from LoginLog u where u.username like %?1%")
	List<LoginLog> findByUsernameLike(String username);
	@Query("select u from LoginLog u where u.sysname like %?1%")
	List<LoginLog> findBySysnameLike(String sysname);
	
	//根据日期查找
	List<LoginLog> findByLoginTimeBetween(Date startDate, Date endDate);
	List<LoginLog> findByLoginTimeAfter(Date startDate);
	List<LoginLog> findByLoginTimeBefore(Date endDate);
	
	//选择唯一的某一属性
	List<String> findDistinctCityByCity(String city);
	List<LoginLog> findByCity(String city);
	List<LoginLog> findBySysname(String sysname);
}
