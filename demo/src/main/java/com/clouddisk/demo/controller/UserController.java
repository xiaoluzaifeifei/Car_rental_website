package com.clouddisk.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clouddisk.demo.common.Result;
import com.clouddisk.demo.entity.User;
import com.clouddisk.demo.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController // 返回json文件
@RequestMapping("/user") // 路由
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        if (userInfoService.login(user) == null) {
            return Result.error("-1", "用户名或密码错误");
        }
        return Result.success();
    }

    @PostMapping // 定义接口, post用于新增
    public Result<?> save(@RequestBody User user) { // 将json文件映射为实体对象;问号表示任何对象
        userInfoService.insert(user);
        return Result.success();
    }

    @GetMapping// get用于查询
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) { // 将json文件映射为实体对象;问号表示任何对象
        return Result.success(userInfoService.selectPage(pageNumber, pageSize, search));
    }

    @PutMapping // put用于修改
    public Result<?> edit(@RequestBody User user) { // 将json文件映射为实体对象;问号表示任何对象
        userInfoService.updateById(user);
        return Result.success();
    }

    @DeleteMapping("/{id}") // delete用于删除
    public Result<?> delete(@PathVariable Long id) { // 将json文件映射为实体对象;问号表示任何对象
        userInfoService.deleteById(id);
        return Result.success();
    }

}
