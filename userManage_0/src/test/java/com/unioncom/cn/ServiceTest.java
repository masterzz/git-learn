package com.unioncom.cn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unioncom.cn.Dao.LoginLogRepository;

//测试spring boot程序
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ServiceTest {
	@Autowired
	LoginLogRepository loginLogRepository;
	
	@Test
	public void testLoginLogService() {
		System.out.println(loginLogRepository);
	}
}
