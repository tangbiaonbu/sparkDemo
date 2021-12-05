package com.ahua.demo;

/**
 * @author 唐少
 * @version 1.0
 * @description: TODO
 * @date 2021/12/5 16:51
 */
import com.ahua.demo.entity.Person;
import org.apache.spark.sql.SparkSession;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        SparkSession spark = SparkSession
                .builder()
                .getOrCreate();

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("zhangsan", 22, "male"));
        persons.add(new Person("lisi", 25, "male"));
        persons.add(new Person("wangwu", 23, "female"));
        spark.createDataFrame(persons, Person.class).show(false);

        spark.close();
    }
}
