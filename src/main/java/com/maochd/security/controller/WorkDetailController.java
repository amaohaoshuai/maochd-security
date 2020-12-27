package com.maochd.security.controller;

import com.maochd.security.entity.WorkInfo;
import com.maochd.security.service.WorkDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workDetail")
public class WorkDetailController {

    @Autowired
    private WorkDetailService workDetailService;

    @PostMapping(value = "/addWork")
    public String addWork(@RequestBody WorkInfo workInfo) {
        if (workDetailService.addWork(workInfo)) {
            return "Add work info success";
        }
        return "Add work info failed";
    }

    @PostMapping(value = "/modifyWork")
    public String modifyWork(@RequestBody WorkInfo workInfo) {
        if (workDetailService.modifyWork(workInfo)) {
            return "Modify work info success";
        }
        return "Modify work info failed";
    }
}
