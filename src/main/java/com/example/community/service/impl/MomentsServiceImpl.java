package com.example.community.service.impl;

import com.example.community.dao.mapper.MomentsMapper;
import com.example.community.domain.Moments;
import com.example.community.service.FavoriteService;
import com.example.community.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;
    @Autowired
    private FavoriteService favoriteService;

    @Override
    public List<Moments> getAllMoments() {
        return momentsMapper.selectAll();
    }

    @Override
    public int publishMoments(Moments moments){
        try {
            return momentsMapper.insertMoments(moments.getmId(), moments.getUser().getuId(), moments.getmTime(), moments.getmText());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int removeMoments(Moments moments) {
        return momentsMapper.delete(moments);
    }

    @Override
    public int likeMoments(Integer u_id, Integer m_id) {
        return favoriteService.favoriteMoment(u_id, m_id);
    }

    @Override
    public int unLikeMoments(Integer u_id, Integer m_id) {
        return favoriteService.cancleFavoriteMoment(u_id, m_id);
    }

    @Override
    public List<Moments> listMomentsByUserId(Integer uId) {
        return momentsMapper.selectMomentByUser(uId);
    }
}
