package org.molecule.demo.spring.cloud.stream.messagereceive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dong ZhuMing
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class MessageReceiveApplication {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiveApplication.class);

    @StreamListener(Sink.INPUT)
    @Transactional(rollbackFor = Exception.class)
    public void input(Message<String> message) {
        logger.info("收到消息：" + message.getPayload());
    }


    public static void main(String[] args) {
        SpringApplication.run(MessageReceiveApplication.class, args);
    }
}
