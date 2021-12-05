package com.ahua.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.hadoop.yarn.client.api.YarnClient;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 唐少
 * @version 1.0
 * @description: 获取yarn上的任务的运行状态
 * @date 2021/12/5 13:26
 */
public class GetYarnApplicationState {
    public static void main(String[] args) {
        Configuration conf = new YarnConfiguration();
        YarnClient yarnClient = YarnClient.createYarnClient();
        yarnClient.init(conf);
        yarnClient.start();

        ApplicationReport applicationReport = null;
        try {

            applicationReport = yarnClient.getApplicationReport(ApplicationId.newInstance(1638680158227L, 10));
            yarnClient.killApplication(ApplicationId.newInstance(1638680158227L,5));
            System.out.println(applicationReport);
        } catch (YarnException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(Objects.requireNonNull(applicationReport).getYarnApplicationState());
        yarnClient.stop();
    }
}
