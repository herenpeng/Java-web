package com.hrp.dao.impl;

import com.hrp.dao.SpikeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author hrp
 * 2020/3/18 22:51
 */
@Repository
public class SpikeDaoImpl implements SpikeDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void addStock(String key,String value) {
        redisTemplate.boundListOps(key).leftPush(value);
    }

    @Override
    public String spike(String key) {
        return (String) redisTemplate.boundListOps(key).leftPop();
    }
}
