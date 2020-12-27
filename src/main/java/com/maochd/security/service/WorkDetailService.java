package com.maochd.security.service;

import com.maochd.security.entity.WorkInfo;

public interface WorkDetailService {
    boolean addWork(WorkInfo workInfo);

    boolean modifyWork(WorkInfo workInfo);
}
