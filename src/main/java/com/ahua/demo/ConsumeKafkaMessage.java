package com.ahua.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author 唐少
 * @version 1.0
 * @description: 本地监听Kafka的topic，并将接受到的数据打印出来
 * @note 当前的消费报错
 * @date 2021/12/5 18:40
 */
public class ConsumeKafkaMessage {
    public static void main(String[] args) {

        Properties properties = new Properties();
        //kafka是服务器地址
        properties.put("bootstrap.servers", "192.168.1.100:9092");
        //自动提交（offset）
        properties.put("enable.auto.commit", "true");
        //自动处理的间隔时间1秒
        properties.put("auto.commit.interval.ms", "1000");
        //key和values的持久化设置
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        //3.订阅消费topic(可以有多个topic)
        kafkaConsumer.subscribe(Arrays.asList("tangbiao"));
        //4.执行消费的操作
        while (true) {
            //100ms消费一次
            //kafkaConsumer.poll(100)读出来，读到records
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("-----------------");
                //打印偏移量，key，value
                System.out.printf("offset = %d, value = %s", record.offset(), record.key(), record.value());
                System.out.println();
            }
        }
    }
}
