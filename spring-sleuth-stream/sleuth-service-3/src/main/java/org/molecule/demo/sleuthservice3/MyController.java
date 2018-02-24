package org.molecule.demo.sleuthservice3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Dong Zhuming on 2017/10/29.
 */
@RestController
@RequestMapping("/")
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private Source source;


//    private final KafkaTemplate kafkaTemplate;

//    @Autowired
//    public MyController(KafkaTemplate kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @RequestMapping("hi")
    public String sayHi() {
        logger.info("Say hi");
        source.output().send(MessageBuilder.withPayload("aaa").build());
        return "hi";
    }
}
