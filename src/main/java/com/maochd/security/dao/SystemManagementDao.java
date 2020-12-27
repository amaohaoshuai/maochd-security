package com.maochd.security.dao;

import com.maochd.security.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SystemManagementDao {
    int addUser(@Param("userInfo") UserInfo user);

    int deleteUser(@Param("userId") String userId);

    UserInfo getUser(@Param("username") String username);

    List<String> getRoles(@Param("userInfo") UserInfo user);
}
