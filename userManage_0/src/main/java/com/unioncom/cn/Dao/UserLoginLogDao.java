package com.unioncom.cn.Dao;

import com.unioncom.cn.bean.Contions;
import com.unioncom.cn.entity.UserLoginLog;
import com.unioncom.cn.entity.UserLoginLogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 */
public class UserLoginLogDao {
    private UserLoginLogRepository userLoginLogRepository;
    private EntityManager entityManager;
    private Contions contions;

    @Bean
    public boolean save( UserLoginLog userLoginLog){
       userLoginLogRepository.save(userLoginLog);
           return true;

    }

    @Bean
    public List<UserLoginLog> findByUsername(String username){
        return userLoginLogRepository.findByUsername(username);
    }

    @Bean
    public  List<UserLoginLog> findBySysname(String sysname){
        return userLoginLogRepository.findBySysname(sysname);
    }

    @Bean
    public  List<UserLoginLog> search(Contions contions){
        String sqlstr_prefix = "select ";
        String  sqlstr2 = "count(*) from UserLoginLog t ";
        String sqlstr_suffix =  "where 1= 1 " ;
        String sqlstr = null;
        if (null != contions ){
            if(!StringUtils.isEmpty(contions.getCity())){
                sqlstr_prefix  += "t.city city , ";
                sqlstr_suffix  += " and t.city = ?1 ";
            };
            if(!StringUtils.isEmpty(contions.getSysname())){
                sqlstr_prefix += " t.sysname sysname , ";
                sqlstr_suffix +=   " and t.sysname =?2 ";
            };
            if(!StringUtils.isEmpty(contions.getBegintime())){
                sqlstr_suffix  += "and t.starttime  >?3 ";
            };
            if(!StringUtils.isEmpty(contions.getEmdtime())){
                sqlstr_suffix += "and t.starttime < ?4 ";
            };
            sqlstr = sqlstr_prefix + sqlstr2 + sqlstr_suffix ;
            Query query  = entityManager.createQuery(sqlstr);
            query.setParameter(1,contions.getCity());
            query.setParameter(2, contions.getSysname());
            query.setParameter(3,contions.getBegintime());
            query.setParameter(4,contions.getEmdtime());

            return query.getResultList();
        }else {
            return userLoginLogRepository.findAll();
        }
    }

}
