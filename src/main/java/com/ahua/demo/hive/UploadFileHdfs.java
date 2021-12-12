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
 * @description: 本地上传文件到HDFS
 * @date 2021/12/12 23:55
 */
public class UploadFileHdfs {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "1");
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.100:9000"), configuration, "root");
        // 2 上传文件
        fs.copyFromLocalFile(new Path("G:\\WorkSpace\\sparkDemo\\src\\main\\resources\\phone.txt"), new Path("/phone.txt"));
        // 3 关闭资源
        fs.close();
        System.out.println("over");
    }
}
