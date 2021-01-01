package com.maochd.security.dao;

import com.maochd.security.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 授权Dao
 *
 * @author maochd
 */
@Mapper
@Repository
public interface RbacAuthorityDao {

    /**
     * 根据用户名获取所有权限
     *
     * @param username
     * @return
     */
    List<String> getUrlsByUsername(@Param("username") String username);

    /**
     * 根据用户名获取用户详细信息
     *
     * @param username
     * @return
     */
    UserInfo getUser(@Param("username") String username);

    /**
     * 根据用户信息获取角色
     *
     * @param user
     * @return
     */
    List<String> getRoles(@Param("userInfo") UserInfo user);
}
