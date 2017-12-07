package org.molecule.demo.sleuthservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private MyService myService;

    @RequestMapping("/service1")
    public String service1() throws Exception {
        log.info("收到HTTP请求service1");
        return myService.doCall();
    }

    @RequestMapping("/hi")
    public String sayHello() {
        return "hello";
    }
}
