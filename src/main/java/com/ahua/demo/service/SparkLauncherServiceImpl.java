package com.ahua.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.launcher.SparkLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author 唐少
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 15:50
 */
@Slf4j
@Service
public class SparkLauncherServiceImpl implements SparkLauncherService {

    @Value("${hadoop.conf.dir}")
    private String hadoop_conf_dir;

    @Value("${java.home}")
    private String java_home;

    @Value("${spark.home.dir}")
    private String spark_home_dir;

    @Value("${spark.driver.memory}")
    private String spark_driver_memory;

    @Value("${spark.executor.memory}")
    private String spark_executor_memory;

    @Value("${spark.executor.cores}")
    private String spark_executor_cores;

    @Value("${spark.executor.instances}")
    private String spark_executor_instances;

    @Value("${spark.default.parallelism}")
    private String spark_default_parallelism;

    @Value("${spark.master}")
    private String spark_master;

    @Value("${spark.deploy.mode}")
    private String spark_deploy_mode;

    @Value("${spark.task.execute.yarn.queue}")
    private String taskExecutorYarnQueue;



    @Override
    public int submit(String jarPath, String mainClass) throws IOException {
        int flag = 0;
        HashMap env = new HashMap();
        env.put("HADOOP_CONF_DIR", hadoop_conf_dir);
        env.put("JAVA_HOME", java_home);

        Process handler = new SparkLauncher(env)
                .setAppName("sparkLaunchDemo")
                .setSparkHome(spark_home_dir)
                .setMaster(spark_master)
                .setConf("spark.driver.memory", spark_driver_memory)
                .setConf("spark.executor.memory", spark_executor_memory)
                .setConf("spark.executor.cores", spark_executor_cores)
                .setConf("spark.executor.instances", spark_executor_instances)
                .setConf("spark.default.parallelism", spark_default_parallelism)
                .setConf("spark.yarn.queue", taskExecutorYarnQueue)
                .setConf("spark.driver.allowMultipleContexts", "true")
                .setAppResource(jarPath)
                .setMainClass(mainClass)
                .setDeployMode(spark_deploy_mode)
                .setVerbose(true)
                .launch();
        try {
            return handler.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }
}