package com.clouddisk.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouddisk.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> { // BaseMapper实现了基本的单表增删改查
    // 一对多查询
    Page<User> findPage(Page<User> page, @Param("nickName") String nickName);

//    @Select("select count(id) count, address from user GROUP BY address")
//    List<UserAddressDto> countAddress();

    // 查询用户名
    @Select("select password from user where username=#{username}")
    User selectByName(String username);

    @Update("update user set password = #{newPassword} where id = #{userId}")
    int updatePassword(Map<String, Object> map);
}
