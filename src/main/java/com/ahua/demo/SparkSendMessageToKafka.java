package com.ahua.demo;

import com.ahua.demo.entity.Person;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.spark.sql.SparkSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 唐少
 * @version 1.0
 * @description: 提交到yarn上的spark任务，发数据到Kafka.ConsumeKafkaMessage 函数是否能管消费
 * @date 2021/12/5 18:13
 */
public class SparkSendMessageToKafka {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().getOrCreate();
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("zhangsan", 22, "male"));
        persons.add(new Person("lisi", 25, "male"));
        persons.add(new Person("wangwu", 23, "female"));
        spark.createDataFrame(persons, Person.class).show(false);

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.100:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("tangbiao", "当前发送第-->" + i + "--->数据"));
        }
        producer.close();
        spark.close();

    }
}
