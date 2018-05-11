package com.unioncom.cn.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5. 定义的数据的访问， By extending CrudRepository,
 * UserLoginLogRepository inherits several methods for working with UserLoginLog
 * persistence, including methods for saving, deleting, and finding UserLoginLog
 * entities.
 * 
 * Spring Data JPA also allows you to define other query methods by simply
 * declaring their method signature. In the case of UserLoginLogRepository, this
 * is shown with a findBySysname() method.
 * 
 * In a typical Java application, you’d expect to write a class that implements
 * CustomerRepository. But that’s what makes Spring Data JPA so powerful: You
 * don’t have to write an implementation of the repository interface. Spring
 * Data JPA creates an implementation on the fly when you run the application.
 */
public interface UserLoginLogRepository extends JpaRepository<UserLoginLog, Long> {
	List<UserLoginLog> findBySysname(String sysname);

	List<UserLoginLog> findByUsername(String username);

	List<UserLoginLog> findByStarttime(String username);

	// define the query directly
	@Query("select u from UserLoginLog u where  u.starttime >= ?1")
	List<UserLoginLog> findAll(String starttime);

}
