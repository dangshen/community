package com.example.community.dao.mapper;

import com.example.community.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户持久层接口
 */
public interface UserMapper extends Mapper<User> {
    @Select("select u_id,u_name from user where u_id = #{u_id}")
    User selectUserById(@Param("u_id") Integer u_id);

    @Select("select * from user where u_id=#{u_id} and u_password=#{u_password}")
    User selectByIdAndPwd(@Param("u_id") Integer u_id, @Param("u_password") String u_password);
}
