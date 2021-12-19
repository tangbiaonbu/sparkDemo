package com.ahua.demo;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
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
        Dataset<Row> sql = sc.sql("select * from ahua.person");
        System.out.println(sql.count());
        sql.show();
        System.out.println("===============================================1");


        Dataset<Row> sq1 = sc.sql("select count(name) from ahua.person");
        sq1.show();
        System.out.println(sq1.count());
        System.out.println(sq1.first().toString());
        System.out.println("===============================================2");


        /*
        6
+---+--------+
| id|    name|
+---+--------+
|  1|tangbiao|
|  2|     ljh|
|  3|   xukai|
|  4|     srr|
|  5|     xjx|
|  6|     smm|
+---+--------+

===============================================1
+-----------+
|count(name)|
+-----------+
|          6|
+-----------+

1
[6]
        * */
        sc.stop();
    }
}
