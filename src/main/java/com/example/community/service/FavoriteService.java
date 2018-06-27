package com.example.community.service;



public interface FavoriteService {

    /**
     * 点赞朋友圈
     * @param u_id
     * @param m_id
     * @return
     */
    int favoriteMoment(Integer u_id, Integer m_id);

    /**
     * 取消点赞
     * @param u_id
     * @param m_id
     * @return
     */
    int cancleFavoriteMoment(Integer u_id, Integer m_id);
}
