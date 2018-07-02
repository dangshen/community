package com.example.community.dao.mapper;

import com.example.community.domain.Favorite;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 点赞列表持久层接口
 */
public interface FavoriteMapper extends Mapper<Favorite> {

    /**
     * 根据u_id和m_id添加点赞数据
     * @param u_id
     * @param m_id
     * @return
     */
    @Insert("insert into favorite(u_id, m_id) values(#{u_id}, #{m_id})")
    int insertByUserAndMoments(@Param("u_id") Integer u_id, @Param("m_id") Integer m_id);

    /**
     * 根据u_id和m_id删除点赞数据
     * @param u_id
     * @param m_id
     * @return
     */
    @Delete("delete from favorite where u_id = #{u_id} and m_id = #{m_id}")
    int deleteByUserAndMoments(@Param("u_id") Integer u_id, @Param("m_id") Integer m_id);

    /**
     * 根据m_id删除点赞数据
     * @param m_id
     * @return
     */
    @Delete("delete from favorite where m_id = #{m_id}")
    int deleteByMoments(@Param("m_id") Integer m_id);

    /**
     * 用于列出朋友圈列表时查询点赞用户
     * @param m_id
     * @return
     */
    @Select("select * from favorite where m_id = #{m_id}")
    @Results({
            @Result(property = "user",
                    column = "u_id",
                    one = @One(select = "com.example.community.dao.mapper.UserMapper.selectUserById"))
    })
    List<Favorite> selectByMoments(@Param("m_id") Integer m_id);
}
