package com.kafka.demo.service;

import com.kafka.demo.model.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group-id}")
    public void consumeMessage(Student student) {
        System.out.println(student.toString());
        System.out.println("received!!!!!");
    }
}
