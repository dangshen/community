package com.example.community.service.impl;

import com.example.community.dao.mapper.MomentsMapper;
import com.example.community.domain.Moments;
import com.example.community.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsMapper momentsMapper;

    @Override
    public List<Moments> getAllMoments() {
        return momentsMapper.selectAll();
    }

    @Override
    public int addMoments(Moments moments) {
        return momentsMapper.insert(moments);
    }

    @Override
    public int removeMoments(Moments moments) {
        return momentsMapper.delete(moments);
    }

    @Override
    public int modifyMoments(Moments moments) {
        return momentsMapper.updateByPrimaryKey(moments);
    }

    @Override
    public List<Moments> listMomentsByUserId(Integer uId) {
        System.out.println(momentsMapper.selectMomentByUser(uId));
        return momentsMapper.selectMomentByUser(uId);
    }
}
