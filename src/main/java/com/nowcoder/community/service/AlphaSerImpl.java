package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author HQ
 * @program: community
 * @description: shxian
 * @date 2022-06-22 23:11:35
 */
@Service
public class AlphaSerImpl implements AlphaService{

    @Autowired
    private AlphaDao alphaDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁AlphaService");
    }

    public String getDao(){
        return alphaDao.select();
    }
}
