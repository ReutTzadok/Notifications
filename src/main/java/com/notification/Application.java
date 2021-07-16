package com.notification;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public NewTopic topic() {
        NewTopic x = TopicBuilder.name("topic-2")
                .partitions(1)
                .replicas(1)
                .build();

        System.out.println("Topic config:");
        System.out.println(x.configs());

         return x;
//        return TopicBuilder.name("topic-2")
//                .partitions(1)
//                .replicas(1)
//                .build();
    }



}