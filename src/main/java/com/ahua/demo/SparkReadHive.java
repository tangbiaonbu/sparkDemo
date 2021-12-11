package com.ahua.demo;

import org.apache.spark.sql.SparkSession;

/**
 * @author 唐少
 * @version 1.0
 * @description: spark 读取hive的表，读取hive的数据数据扫描
 * @date 2021/12/5 20:07
 */
public class SparkReadHive {
    public static void main(String[] args) {
        SparkSession sc = SparkSession.builder()
                .enableHiveSupport()
                .config("spark.sql.warehouse.dir", "hdfs://192.168.1.100:8020/user/hive/warehouse")
                .getOrCreate();
        sc.sql("use ahua");
        sc.sql("select * from ahua.person").show();
        sc.sql("select count(*) from ahua.person where ahua.person.name='tangbiao'").show();
        sc.stop();
    }
}
