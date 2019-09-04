package com.kafka.demo.controller;

import com.kafka.demo.model.Student;
import com.kafka.demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    Producer producer;

    @GetMapping("/")
    public String getHome(){
        return "Welcome";
    }
    @PostMapping("/")
    public String publish(@RequestBody Student student){
        producer.produceMessage(student);
        return "success";
    }
}
