package com.unioncom.cn.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by guowei on 2018/1/30 descr:用以记录用户的登陆日志
 */
@Entity
public class UserLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	// 用户名
	private String username;

	// 工号
	private String job_num;

	// 月累计登录次数
	private int month_accum_login_num;

	// 累计登录次数
	private int accum_login_num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJob_num() {
		return job_num;
	}

	public void setJob_num(String job_num) {
		this.job_num = job_num;
	}

	public int getMonth_accum_login_num() {
		return month_accum_login_num;
	}

	public void setMonth_accum_login_num(int month_accum_login_num) {
		this.month_accum_login_num = month_accum_login_num;
	}

	public int getAccum_login_num() {
		return accum_login_num;
	}

	public void setAccum_login_num(int accum_login_num) {
		this.accum_login_num = accum_login_num;
	}
}
