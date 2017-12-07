package org.molecule.demo.sleuthservice3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Dong Zhuming on 2017/10/29.
 */
@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @RequestMapping("/hi")
    public String sayHi() {
        logger.info("Say hi");
        return "hi";
    }
}
