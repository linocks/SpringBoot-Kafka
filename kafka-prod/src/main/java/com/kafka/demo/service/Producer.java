package com.kafka.demo.service;

import com.kafka.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Producer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    String topic;

    public void produceMessage(Student student){
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC,topic);

        kafkaTemplate.send(new GenericMessage<>(student, headers));
        System.out.println("student sent......");
    }
}
