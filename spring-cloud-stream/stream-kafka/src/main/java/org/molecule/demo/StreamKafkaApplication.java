package org.molecule.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamKafkaApplication {

	private static final Logger logger = LoggerFactory.getLogger(StreamKafkaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StreamKafkaApplication.class, args);
	}


	@StreamListener(Sink.INPUT)
	public void processMessage(String text) {
		logger.info(text);
	}
}
