package com.maochd.security.service;

import com.maochd.security.entity.UserInfo;

public interface SystemManagementService {
    boolean addUser(UserInfo user);

    boolean deleteUser(String userId);
}
