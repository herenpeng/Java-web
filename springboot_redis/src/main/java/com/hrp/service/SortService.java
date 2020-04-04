package com.hrp.service;

import java.util.Set;

/**
 * @author hrp
 * 2020/3/19 19:54
 */
public interface SortService {
    /**
     * 点击功能，修改排名,每点击一次，排名分数+1
     * @param name
     * @param score
     */
    void onClick(String name,Double score);

    /**
     * 获取所有排名
     * @return
     */
    Set<String> getSort();

    /**
     * 获取单个的排名分数
     * @param name
     * @return
     */
    Double getScore(String name);
}
