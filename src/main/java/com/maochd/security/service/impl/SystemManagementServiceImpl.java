package com.maochd.security.service.impl;

import com.maochd.security.dao.SystemManagementDao;
import com.maochd.security.entity.UserInfo;
import com.maochd.security.service.SystemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemManagementServiceImpl implements SystemManagementService {

    @Autowired
    private SystemManagementDao systemManagementDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(UserInfo user) {
        return systemManagementDao.addUser(user) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(String userId) {
        return systemManagementDao.deleteUser(userId) > 0;
    }
}
