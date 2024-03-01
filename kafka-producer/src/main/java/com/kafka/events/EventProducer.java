package com.kafka.events;

import com.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

@Slf4j
public class EventProducer {
    private Producer<String, String> producer;

    public EventProducer() {
        producer = createProducer();
    }

    private Producer<String, String> createProducer() {
        if (Objects.nonNull(producer)) {
            return producer;
        }

        var properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        return new KafkaProducer<>(properties);
    }

    public void execute() {
        var key = UUID.randomUUID().toString();
        var date = LocalDate.now().toString();
        var message = date + "|" + key;

        log.info(Constants.START_PRODUCER);
        var record = new ProducerRecord<>(Constants.TOPIC_NAME, key, message);
        producer.send(record);
        producer.flush();
        producer.close();
        log.info("Message sent successfully '{}'", message);
    }


}
