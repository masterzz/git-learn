package com.unioncom.cn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/30.
 */

public class Contions {
    private  String searchString;
    private String city;
    private String sysname;
    private Date begintime;
    private Date emdtime;

    public Contions( ) {

    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEmdtime() {
        return emdtime;
    }

    public void setEmdtime(Date emdtime) {
        this.emdtime = emdtime;
    }
}
