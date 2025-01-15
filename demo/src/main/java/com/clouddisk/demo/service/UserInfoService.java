package com.clouddisk.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouddisk.demo.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserInfoService {
    User selectByName(String name);
    User selectById(int id);
    void insert(User user);
    void updateById(User user);
    void deleteById(Long id);
    Page<User> selectPage(Integer pageNumber, Integer pageSize, String search);
    User login(User user);
}
