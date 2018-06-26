package com.example.community.service;


import com.example.community.domain.Moments;

import java.util.List;

public interface MomentsService {
    /**
     * 朋友圈列表
     * @return
     */
    List<Moments> getAllMoments();

    /**
     * 发布朋友圈
     * @param moments
     * @return
     */
    int addMoments(Moments moments);

    /**
     * 删除朋友圈
     * @param moments
     * @return
     */
    int removeMoments(Moments moments);

    /**
     * 修改朋友圈
     * @param moments
     * @return
     */
    int modifyMoments(Moments moments);

    /**
     * 根据用户查询朋友圈
     * @param uId
     * @return
     */
     List<Moments> listMomentsByUserId(Integer uId);
}
