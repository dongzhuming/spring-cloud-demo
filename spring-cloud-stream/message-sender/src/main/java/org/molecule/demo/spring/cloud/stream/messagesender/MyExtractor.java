package org.molecule.demo.spring.cloud.stream.messagesender;

import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;

/**
 * @author Dong ZhuMing
 * @date 2017/12/20.
 */
public class MyExtractor implements PartitionKeyExtractorStrategy {

    @Override
    public Object extractKey(Message<?> message) {
        return Integer.valueOf(message.getHeaders().getReplyChannel().toString());
    }
}
