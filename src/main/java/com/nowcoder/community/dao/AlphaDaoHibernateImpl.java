package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author HQ
 * @program: community
 * @description: dao实现
 * @date 2022-06-20 23:22:09
 */
@Repository("hibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {

    @Override
    public String select() {
        System.out.println("hello");
        return "hello";
    }
}
