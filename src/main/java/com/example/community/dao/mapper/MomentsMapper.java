package com.example.community.dao.mapper;

import com.example.community.domain.Moments;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * 朋友圈持久层接口
 */
public interface MomentsMapper extends Mapper<Moments> {
    @Select("select * from moments where u_id = #{uId}")
    @Results({
            @Result(property = "user",
                    column = "u_id",
                    one = @One(select = "com.example.community.dao.mapper.UserMapper.selectUserById"))
    })
    List<Moments> selectMomentByUser(@Param("uId")Integer uId);

    @Select("select * from moments")
    @Results({
            @Result(property = "user",
                    column = "u_id",
                    one = @One(select = "com.example.community.dao.mapper.UserMapper.selectUserById"))
    })
    List<Moments> selectAll();

    @Insert("insert into moments(m_id,u_id,m_time,m_text) values(#{m_id},#{u_id},#{m_time},#{m_text})")
    int insertMoments(@Param("m_id") Integer m_id, @Param("u_id") Integer u_id, @Param("m_time") Timestamp m_time, @Param("m_text") String m_text);
}
