package com.maochd.security.dao;

import com.maochd.security.entity.WorkInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkDetailDao {

    int addWork(@Param("workInfo") WorkInfo workInfo);

    int modifyWork(@Param("workInfo") WorkInfo workInfo);
}
