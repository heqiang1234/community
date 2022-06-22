package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author HQ
 * @program: community
 * @description: alpha服务类
 * @date 2022-06-20 23:35:48
 */
@Service
public interface AlphaService {

    public void init();

    public void destory();

    public String getDao();
}
