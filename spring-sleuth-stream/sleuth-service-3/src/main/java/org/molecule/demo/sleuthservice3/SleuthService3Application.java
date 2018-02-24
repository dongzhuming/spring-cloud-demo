package org.molecule.demo.sleuthservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

//@EnableZipkinStreamServer
//@EnableBinding(SleuthSink.class)
@SpringBootApplication
//@MessageEndpoint
@EnableBinding(Source.class)
public class SleuthService3Application {

    public static void main(String[] args) {
        SpringApplication.run(SleuthService3Application.class, args);
    }
}
