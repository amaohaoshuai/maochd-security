package com.maochd.security.service.impl;

import com.maochd.security.dao.WorkDetailDao;
import com.maochd.security.entity.WorkInfo;
import com.maochd.security.service.WorkDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkDetailServiceImpl implements WorkDetailService {

    @Autowired
    private WorkDetailDao workDetailDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addWork(WorkInfo workInfo) {
        return workDetailDao.addWork(workInfo) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyWork(WorkInfo workInfo) {
        return workDetailDao.modifyWork(workInfo) > 0;
    }
}
