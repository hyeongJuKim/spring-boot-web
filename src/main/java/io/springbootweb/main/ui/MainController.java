package io.springbootweb.main.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/")
    public String home(Model model) {
        log.info("main page");
        model.addAttribute("paramTest", "test");
        return "main/main";
    }

}
