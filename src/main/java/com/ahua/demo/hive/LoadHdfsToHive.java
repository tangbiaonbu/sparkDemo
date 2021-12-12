package com.ahua.demo.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 唐少
 * @version 1.0
 * @description: 将HDFS上的文件存储到HIVE
 * @date 2021/12/12 23:57
 */
public class LoadHdfsToHive {
    public static void main(String[] args) {
        String JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
        String CONNECTION_URL = "jdbc:hive2://192.168.1.100:10000/default";
        String username = "root";
        String password = "123456";
        Connection con = null;

        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(CONNECTION_URL, username, password);
            Statement stmt = con.createStatement();

//            stmt.execute("create database test_db");
//            stmt.execute("create table if not exists test_db.demo(txt string)");

//            String sql = " load data inpath '" + "/phone.txt" + "' into table test_db.demo ";

//            state.execute("drop table student");

            stmt.execute("drop table test_db.demo");
            System.out.println("loadData到Hive表成功！");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
