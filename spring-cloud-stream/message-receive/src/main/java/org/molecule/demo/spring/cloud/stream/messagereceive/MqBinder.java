package org.molecule.demo.spring.cloud.stream.messagereceive;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 声明一个MQ Interface
 * Created by dongzm on 2017/9/30.
 */
public interface MqBinder {

    String INPUT = "input";

    @Input("input")
    SubscribableChannel inputChannel();

}