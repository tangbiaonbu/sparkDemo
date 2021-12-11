package com.ahua.demo.entity;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 唐少
 * @version 1.0
 * @description: TODO
 * @date 2021/12/11 19:15
 */
public class PersonDemo {
    public static void main(String[] args) {
        List<Person> peoples = new ArrayList<>();
        peoples.add(new Person("tb",18,"boy"));
        peoples.add(new Person("xk",19,"boy"));
        peoples.add(new Person("srr",20,"girl"));
        peoples.add(new Person("ljh",21,"boy"));

        System.out.println(Arrays.toString(peoples.toArray()));
//        String s = JSON.toJSONString(peoples).toString();
//        System.out.println(s);
    }
}
