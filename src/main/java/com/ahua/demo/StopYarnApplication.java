package com.ahua.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;

import java.io.IOException;

/**
 * @author 唐少
 * @version 1.0
 * @description: 将yarn上正在运行的任务停止。
 * @date 2021/12/5 14:24
 */
public class StopYarnApplication {
    public static void main(String[] args) {
        Configuration conf = new YarnConfiguration();
        YarnClient yarnClient = YarnClient.createYarnClient();
        yarnClient.init(conf);
        yarnClient.start();

        ApplicationReport applicationReport = null;
        try {
            yarnClient.killApplication(ApplicationId.newInstance(1638680158227L, 5));
        } catch (YarnException | IOException e) {
            e.printStackTrace();
        }
        yarnClient.stop();
    }
}