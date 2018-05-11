package com.unioncom.cn.service.impl;

import java.net.Socket;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unioncom.cn.Dao.UserRepository;
import com.unioncom.cn.bean.User;
import com.unioncom.cn.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public String connect(String ip, int port) {
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(ip, port);
			clientSocket.close();
			return "端口已打开";
		} catch (Exception e) {
			return "不能连接指定主机、端口";
		}
	}

	@Override
	public User findByNameAndPassword(String username, String password) {
		List<User> users = userRepository.findByUsernameAndPassword(username, password);
		if (users.size() > 0)
			return users.get(0);
		return null;
	}

	@Override
	public User findByUsername(String username) {
		List<User> users = userRepository.findByUsername(username);
		if (users.size() >0)
			return users.get(0);
		return null;
	}
}
