package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author HQ
 * @program: community
 * @description: mybatis实现dao
 * @date 2022-06-20 23:25:17
 */
@Repository("mybatis")
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "mybatis";
    }
}
