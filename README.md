# Open Source is yyds, helps rookies to baldness.

## (1) YARN 中的任务如何进行停止

```http
https://cloud.tencent.com/developer/article/1807709
```

## (2)使用SparkLaunch提交spark任务

```http
https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/launcher/package-summary.html
https://blog.csdn.net/helloxiaozhe/article/details/116127070
https://blog.csdn.net/weixin_44455388/article/details/120654616
https://www.cnblogs.com/itboys/p/9958933.html
```

## (3) spark 发数据到Kafka

```http
https://blog.csdn.net/qq_27093465/article/details/107596269
https://kafka.apache.org/0102/javadoc/index.html?org/apache/kafka/clients/producer/KafkaProducer.html

#springboot消费kafka数据
https://blog.csdn.net/u012448904/article/details/88634193
```

## (4) 常用操作命令

### hadoop
```shell
# 启动
sbin/start-dfs.sh
hadoop-daemon.sh start datanode
sbin/start-yarn.sh
```

### zookeeper
```shell
# start zk
bin/zkServer.sh start
bin/zkServer.sh start
bin/zkServer.sh start
# stop zk
bin/zkServer.sh stop
bin/zkServer.sh stop
bin/zkServer.sh stop
```

### Kafka
```shell
# start kakfa
bin/kafka-server-start.sh -daemon config/server.properties
bin/kafka-server-start.sh -daemon config/server.properties
bin/kafka-server-start.sh -daemon config/server.properties
# stop kafka 
bin/kafka-server-stop.sh stop
bin/kafka-server-stop.sh stop
bin/kafka-server-stop.sh stop
#查看Kafka的topic
bin/kafka-topics.sh --zookeeper hadoop100:2181 --list
#生产和消费Kafka的数据
bin/kafka-console-producer.sh --broker-list hadoop100:9092 --topic tangbiao
bin/kafka-console-consumer.sh --zookeeper hadoop100:2181 --topic tangbiao
#删除topic
bin/kafka-topics.sh --zookeeper hadoop100:2181 --delete --topic tangbiao
```

### hive

```shell
# 启动hive
bin/hive
# 查看数据库
show databases;
```

