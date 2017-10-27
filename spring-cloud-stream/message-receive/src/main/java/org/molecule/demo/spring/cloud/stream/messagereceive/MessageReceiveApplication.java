package org.molecule.demo.spring.cloud.stream.messagereceive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableBinding(MqBinder.class)
public class MessageReceiveApplication {

    // 监听 binding 为 Sink.INPUT 的消息
    @StreamListener(MqBinder.INPUT)
    @Transactional
    public void input(Message<String> message) {
        System.out.println("一般监听收到：" + message.getPayload());
        throw new RuntimeException("Throw a runtime exception");
    }


    public static void main(String[] args) {
        SpringApplication.run(MessageReceiveApplication.class, args);
    }
}
