package ru.voskhod.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @RequestMapping("/")
    public String index() {
        logger.info("Main page");
        return "index";
    }

}
