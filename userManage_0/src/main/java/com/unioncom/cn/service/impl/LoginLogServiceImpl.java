package com.unioncom.cn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unioncom.cn.Dao.LoginLogRepository;
import com.unioncom.cn.bean.LoginLog;
import com.unioncom.cn.convert.StringToDateConverter;
import com.unioncom.cn.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService {
	@Autowired
	LoginLogRepository loginLogRepository;

	@Override
	public List<LoginLog> getAll() {
		return loginLogRepository.findAll();
	}

	@Override
	public List<LoginLog> findByKeyWord(String key) {
		List<LoginLog> result = new ArrayList<LoginLog>();
		// 根据关键词，将所有like改关键词的对象找出来
		result = addOnce(result, loginLogRepository.findByCityLike(key));
		result = addOnce(result, loginLogRepository.findBySysnameLike(key));
		result = addOnce(result, loginLogRepository.findByUsernameLike(key));
		return result;
	}

	private List<LoginLog> addOnce(List<LoginLog> result, List<LoginLog> findings) {
		for (LoginLog log : findings) {
			if (!result.contains(log))
				result.add(log);
		}
		return result;
	}

	@Override
	public List<LoginLog> findByConditions(String key, String city, String sysname, Date beginTime, Date endTime) {
		// 校验4个属性值，为空时表示并集，存在时为交集
		List<LoginLog> keyLogs = new ArrayList<LoginLog>();
		keyLogs = findByKeyWord(key);

		// 第2各条件city
		List<LoginLog> cityLogs = null;
		boolean cityFlag = true;
		if (city != null && !city.equals("")) {
			cityFlag = false;
			cityLogs = loginLogRepository.findByCity(city);
		}

		// 第3各条件sysname
		List<LoginLog> sysnameLogs = null;
		boolean sysnameFlag = true;
		if (sysname != null && !sysname.equals("")) {
			sysnameFlag = false;
			sysnameLogs = loginLogRepository.findBySysname(sysname);
		}

		// 第4各条件time
		if (beginTime == null)
			beginTime = new StringToDateConverter("yyyy-MM-dd").convert("1000-1-1");
		if (endTime == null)
			endTime = new StringToDateConverter("yyyy-MM-dd").convert("3000-1-1");
		List<LoginLog> dateLogs = loginLogRepository.findByLoginTimeBetween(beginTime, endTime);

		// 处理结果集
		List<LoginLog> result = new ArrayList<LoginLog>();
		result = union(result, keyLogs);
		if (!cityFlag)
			result = intersection(result, cityLogs);
		if (!sysnameFlag)
			result = intersection(result, sysnameLogs);
		result = intersection(result, dateLogs);
		return result;
	}

	private List<LoginLog> intersection(List<LoginLog> result, List<LoginLog> logs) {
		List<LoginLog> newResult = new ArrayList<LoginLog>();
		for (LoginLog log : logs) {
			if (result.contains(log))
				newResult.add(log);
		}
		return newResult;
	}

	private List<LoginLog> union(List<LoginLog> result, List<LoginLog> logs) {
		for (LoginLog log : logs) {
			if (!result.contains(log))
				result.add(log);
		}
		return result;
	}
}
