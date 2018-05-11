package com.unioncom.cn.service;

import java.util.List;

import com.unioncom.cn.bean.User;

public interface UserService {
	public List<User> getAll();
	public void save(User user);
	public String connect(String ip, int port);
	public User findByNameAndPassword(String username, String password);
	public User findByUsername(String username);
	
}
