package com.hrp.dao.impl;

import com.hrp.dao.SortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author hrp
 * 2020/3/19 16:59
 */
@Repository
public class SortDaoImpl implements SortDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onClick(String key, String name, Double score) {
        redisTemplate.boundZSetOps(key).incrementScore(name,score);
    }

    @Override
    public Set<String> getSort(String key, Long start, Long end) {
        return redisTemplate.boundZSetOps(key).range(start, end);
    }

    @Override
    public Double getScore(String key, String name) {
        return redisTemplate.boundZSetOps(key).score(name);
    }
}
