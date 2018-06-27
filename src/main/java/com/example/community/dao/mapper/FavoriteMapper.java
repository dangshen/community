package com.example.community.dao.mapper;

import com.example.community.domain.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

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
}
