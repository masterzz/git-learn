package com.unioncom.cn.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2018/2/5.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "QUERY_FIND_BY_SYSNAME",
                query = "select sysname from UserLoginLog u where u.sysname   = :sysname"),
        @NamedQuery(name = "QUERY_FIND_BY_username",
                query = "select username  from UserLoginLog u where u.username = :username")
})

public class UserLoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sysname;
    private String username;
    private Date starttime;

    public UserLoginLog() {
    }

    public UserLoginLog(String sysname, String username, Date starttime) {
        this.sysname = sysname;
        this.username = username;
        this.starttime = starttime;
    }

    @Override
    public String toString(){
        return String.format(
                "UserLoginLog[id=%d,sysname= '%s' ,username ='%s'"
        );
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
}
