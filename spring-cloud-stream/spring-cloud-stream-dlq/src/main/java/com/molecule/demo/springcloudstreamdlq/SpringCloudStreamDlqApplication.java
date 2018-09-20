package com.molecule.demo.springcloudstreamdlq;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

/**
 * @author dongzhuming
 */
@SpringBootApplication
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class SpringCloudStreamDlqApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamDlqApplication.class, args);
    }

    private final Source source;
    @Override
    public void run(String... args) throws Exception {
        source.output().send(MessageBuilder.withPayload("Test DLQ").build());
    }
}
