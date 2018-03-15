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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author Dong ZhuMing
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class MessageReceiverApplication {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiverApplication.class);

    private AtomicLong atomicLong = new AtomicLong();
    private Map<Long, Void> map = new ConcurrentHashMap<>();

    @StreamListener(Sink.INPUT)
    @Transactional(rollbackFor = Exception.class)
    public void input(Message<String> message) {
        long count = atomicLong.incrementAndGet();
        try {
            map.put(count, null);
            logger.info("Processing:\t[{}]", count);
            Thread.sleep(new Random().nextInt(5000));
            logger.info("      Done:\t[{}]", count);
        } catch (InterruptedException e) {
            logger.error("Terminate Exceptionally");
        } finally {
            map.remove(count);
        }
    }

    @PostConstruct
    public void init() {
        logger.info("Start listening");
    }

    @PreDestroy
    public void tearDown() throws InterruptedException {
        logger.info("Closing...");
        while(map.size() > 0) {
            logger.warn("Waiting for Stream job done");
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MessageReceiverApplication.class, args);
    }
}
