package com.clouddisk.demo.service.implement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoServiceImplTest {
    @Test
    public void userInfoServiceImplTestTest(){
        UserInfoServiceImpl userInfoService = new UserInfoServiceImpl();
        System.out.println(userInfoService.selectById(1).getUsername());
    }
}