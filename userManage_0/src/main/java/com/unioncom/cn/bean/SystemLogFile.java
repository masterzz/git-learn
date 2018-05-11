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
public class SystemLogFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	private String sysname_en;

	private String sysname_cn;

	private String person_in_charge;

	private String ip;

	private String mkdir;

	private String file_name;
	
	private String size;
	
	private Date systime;
	
	private String port;

	public SystemLogFile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysname_en() {
		return sysname_en;
	}

	public void setSysname_en(String sysname_en) {
		this.sysname_en = sysname_en;
	}

	public String getSysname_cn() {
		return sysname_cn;
	}

	public void setSysname_cn(String sysname_cn) {
		this.sysname_cn = sysname_cn;
	}

	public String getPerson_in_charge() {
		return person_in_charge;
	}

	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMkdir() {
		return mkdir;
	}

	public void setMkdir(String mkdir) {
		this.mkdir = mkdir;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getSystime() {
		return systime;
	}

	public void setSystime(Date systime) {
		this.systime = systime;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
