package com.ahua.demo.controller;

import com.ahua.demo.service.SparkLauncherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 唐少
 * @version 1.0
 * @description: 任务提交
 * @date 2021/12/5 15:50
 */
@Slf4j
@RestController
public class SparkLauncherController {

    @Autowired
    private SparkLauncherService sparkLauncherService;

    // 参数存在非法字符,get方法会报错
    @PostMapping("/submitYarn")
    public int run(String jarPath, String mainClass) throws IOException {
        return sparkLauncherService.submit(jarPath, mainClass);
    }
}
