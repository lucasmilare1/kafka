package com.kafka.events;

import com.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class EventConsumer {

    private KafkaConsumer<String, String> consumer;

    public EventConsumer() {
        consumer = createConsumer();
    }

    private KafkaConsumer<String, String> createConsumer() {
        if (Objects.nonNull(consumer)) {
            return consumer;
        }

        var properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "default");

        return new KafkaConsumer<>(properties);
    }

    public void execute() {
        var topics = new ArrayList<String>();
        topics.add(Constants.TOPIC_NAME);
        consumer.subscribe(topics);

        log.info(Constants.START_CONSUMER);

        consumerJob();

        consumer.close();
    }

    private void consumerJob() {
        var proceed = true;
        while (proceed) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                recordMessage(record.topic(), record.partition(), record.value());
                if (record.value().equals(Constants.CLOSE)) {
                    proceed = false;
                }
            }
        }
    }

    private void recordMessage(String topic, int partition, String message) {
        log.info("topic: '{}', partition: '{}', message: '{}'", topic, partition, message);
    }
}
