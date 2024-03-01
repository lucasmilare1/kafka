package com.kafka.consumer;

import com.kafka.events.EventConsumer;
import com.kafka.utils.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationConsumer {

    public static void main(String[] args) {
        var application = new ApplicationConsumer();
        application.start();
    }

    private void start(){
        log.info(Constants.START);
        var consumer = new EventConsumer();
        consumer.execute();
    }
}
