package org.molecule.demo.spring.cloud.stream.messagesender;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;


/**
 * @author Dong ZhuMing
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class MessageSenderApplication implements ApplicationRunner {

	@SendTo(Source.OUTPUT)
	public Message<?> publish() {
		return MessageBuilder.withPayload("A useless message").build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageSenderApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		publish();
	}
}
