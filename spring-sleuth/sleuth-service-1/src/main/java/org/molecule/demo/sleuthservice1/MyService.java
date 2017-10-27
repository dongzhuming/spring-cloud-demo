package org.molecule.demo.sleuthservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {
    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    private String url = "http://localhost:9986";

    @Autowired
    private RestTemplate restTemplate;

    public String doCall() throws Exception {
        Thread.sleep(200L);
        log.info("发送HTTP请求至" + url);
        String s = this.restTemplate.getForObject(url + "/service2", String.class);
        log.info("收到响应");
        return s;
    }
}
