package com.example.community.dao.mapper;

import com.example.community.domain.Moments;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 朋友圈持久层接口
 */
public interface MomentsMapper extends Mapper<Moments> {
    @Select("select * from moments where u_id = #{id}")
    @Results({
            @Result(property = "user",
                    column = "u_id",
                    one = @One(select = "com.example.community.dao.mapper.UserMapper.selectUserById"))
    })
    List<Moments> selectMomentByUser(Integer id);
}
