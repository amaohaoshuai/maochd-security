package com.maochd.security.controller;

import com.maochd.security.entity.UserInfo;
import com.maochd.security.service.SystemManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/systemManagement")
public class SystemManagementController {

    @Autowired
    private SystemManagementService systemManagementService;

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody UserInfo user) {
        if (systemManagementService.addUser(user)) {
            return "Add user success";
        }
        return "Add user failed";
    }

    @PostMapping(value = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        if (systemManagementService.deleteUser(userId)) {
            return "Delete User success";
        }
        return "Delete User failed";

    }
}
