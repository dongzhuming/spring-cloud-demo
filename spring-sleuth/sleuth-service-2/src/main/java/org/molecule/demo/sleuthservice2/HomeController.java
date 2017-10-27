package org.molecule.demo.sleuthservice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/service2")
    public String service1() throws Exception {
        log.info("收到HTTP请求service2");
        Thread.sleep(100L);
        log.info("返回service2");
        return "service2";
    }
}
