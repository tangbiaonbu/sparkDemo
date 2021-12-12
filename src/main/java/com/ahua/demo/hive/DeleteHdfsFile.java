package com.ahua.demo.hive;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 唐少
 * @version 1.0
 * @description: 删除hdfs文件
 * @date 2021/12/12 23:58
 */
public class DeleteHdfsFile {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.100:9000"), configuration, "root");
        // 2 删除文件
        fs.delete(new Path("/phone.txt"),true);
        // 3 关闭资源
        fs.close();
        System.out.println("over");
    }
}
