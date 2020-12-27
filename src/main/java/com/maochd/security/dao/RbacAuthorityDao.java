package com.maochd.security.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RbacAuthorityDao {
    List<String> getUrlsByUsername(@Param("username") String username);
}
