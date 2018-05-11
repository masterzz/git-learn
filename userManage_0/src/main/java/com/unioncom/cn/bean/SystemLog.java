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
public class SystemLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	private String city;

	private String sysname;
	
	//同时在线人数
	private int online_num;
	
	//当日登录人数
	private int day_login_num;
	
	//当月累计	登录人次
	private int month_accum_login_num;
	
	//累计登录人次
	private int accum_login_num;

	public SystemLog() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public int getOnline_num() {
		return online_num;
	}

	public void setOnline_num(int online_num) {
		this.online_num = online_num;
	}

	public int getDay_login_num() {
		return day_login_num;
	}

	public void setDay_login_num(int day_login_num) {
		this.day_login_num = day_login_num;
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
