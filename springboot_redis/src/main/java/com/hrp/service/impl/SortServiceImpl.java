package com.hrp.service.impl;

import com.hrp.dao.SortDao;
import com.hrp.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author hrp
 * 2020/3/19 19:55
 */
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortDao sortDao;

    private final static String KEY = "sort";

    @Override
    public void onClick(String name, Double score) {
        sortDao.onClick(KEY, name, score);
    }

    @Override
    public Set<String> getSort() {
        return sortDao.getSort(KEY, 0L, -1L);
    }

    @Override
    public Double getScore(String name) {
        return sortDao.getScore(KEY, name);
    }
}
