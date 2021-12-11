package com.ahua.demo;

import com.ahua.demo.entity.Person;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.spark.sql.SparkSession;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 唐少
 * @version 1.0
 * @description: TODO
 * @date 2021/12/11 19:28
 */
public class SparkParams {
    public static void main(String[] args) {
        SparkSession sc = SparkSession.builder().getOrCreate();
        JSONArray js = JSON.parseArray(args[0]);
        List<Person> people = js.toJavaList(Person.class);
        System.out.println("浙江大华技术股份有限公司");
        System.out.println(Arrays.toString(people.toArray()));
        sc.stop();
    }
}
