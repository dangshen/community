package com.example.community.service.impl;

import com.example.community.dao.mapper.FavoriteMapper;
import com.example.community.domain.Favorite;
import com.example.community.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public int favoriteMoment(Integer u_id, Integer m_id) {
        return favoriteMapper.insertByUserAndMoments(u_id, m_id);
    }

    @Override
    public int cancleFavoriteMoment(Integer u_id, Integer m_id) {
        return favoriteMapper.deleteByUserAndMoments(u_id, m_id);
    }

    @Override
    public int removeAllFatoriteByMoments(Integer m_id) {
        return favoriteMapper.deleteByMoments(m_id);
    }

}
