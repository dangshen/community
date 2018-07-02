package com.example.community.service;


import com.example.community.domain.Favorite;
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
    int publishMoments(Moments moments);

    /**
     * 删除朋友圈
     * @param moments
     * @return
     */
    int removeMoments(Moments moments);

    /**
     * 点赞朋友圈
     * @param u_id
     * @param m_id
     * @return
     */
    int likeMoments(Integer u_id, Integer m_id);

    /**
     * 取消点赞
     * @param u_id
     * @param m_id
     * @return
     */
    int unLikeMoments(Integer u_id, Integer m_id);

    /**
     * 根据用户查询朋友圈
     * @param uId
     * @return
     */
     List<Moments> listMomentsByUserId(Integer uId);

    /**
     * 根据m_id查找朋友圈
     * @param mId
     * @return
     */
     Moments findMomentsById(Integer mId);
}
