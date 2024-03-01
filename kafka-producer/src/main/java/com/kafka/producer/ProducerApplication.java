package com.kafka.producer;

import com.kafka.events.EventProducer;
import com.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProducerApplication {


    public static void main(String[] args) {
        var application = new ProducerApplication();
        application.start();
    }

    private void start(){
        log.info(Constants.START);
        var producer = new EventProducer();
        producer.execute();
    }
}
