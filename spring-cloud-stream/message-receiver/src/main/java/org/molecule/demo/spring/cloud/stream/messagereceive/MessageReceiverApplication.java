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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Dong ZhuMing
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class MessageReceiverApplication {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiverApplication.class);

    @StreamListener(Sink.INPUT)
    @Transactional(rollbackFor = Exception.class)
    public void input(Message<String> message) {
        try {
            logger.info("Received a Message：[{}]", message.getPayload());
            Thread.sleep(50);
        } catch(InterruptedException e) {
            logger.error("Terminate Exceptionally");
        }
    }

    @PostConstruct
    public void init() {
        logger.info("Start listening");
    }

    @PreDestroy
    public void tearDown() {
        logger.info("Closing...");
    }

    public static void main(String[] args) {
        SpringApplication.run(MessageReceiverApplication.class, args);
    }
}
