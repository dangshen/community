package com.example.community.service.impl;

import com.example.community.dao.mapper.MomentsMapper;
import com.example.community.domain.Moments;
import com.example.community.service.FavoriteService;
import com.example.community.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;
    @Autowired
    private FavoriteService favoriteService;

    @Override
    public List<Moments> getAllMoments() {
        List<Moments> list = momentsMapper.selectAll();
        System.out.println("list on MomentsMapper: " + list);
        return list;
    }

    @Override
    public int publishMoments(Moments moments){
        return momentsMapper.insertMoments(moments.getmId(), moments.getUser().getuId(), moments.getmTime(), moments.getmText());
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

    @Override
    public Moments findMomentsById(Integer mId) {
        return momentsMapper.selectByPrimaryKey(mId);
    }
}
