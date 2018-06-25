package com.example.community.service;


import com.example.community.domain.Moments;

import java.util.List;

public interface MomentsService {
    /**
     * 朋友圈列表
     * @return
     */
    public List<Moments> getAllMoments();

    /**
     * 发布朋友圈
     * @param moments
     * @return
     */
    public int addMoments(Moments moments);

    /**
     * 删除朋友圈
     * @param moments
     * @return
     */
    public int deleteMoments(Moments moments);

    /**
     * 修改朋友圈
     * @param moments
     * @return
     */
    public int updateMoments(Moments moments);
}
