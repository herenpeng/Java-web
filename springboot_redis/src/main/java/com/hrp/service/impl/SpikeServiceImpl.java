package com.hrp.service.impl;

import com.hrp.dao.SpikeDao;
import com.hrp.service.SpikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hrp
 * 2020/3/18 22:48
 */
@Service
public class SpikeServiceImpl implements SpikeService {

    @Autowired
    private SpikeDao spikeDao;

    private final static String KEY = "commodity";

    @Override
    public void addStock(int stock) {
        for(int i = 0; i < stock; i++) {
            spikeDao.addStock(KEY,"智能手表");
        }
    }

    @Override
    public String spike() {
        return spikeDao.spike(KEY);
    }
}
