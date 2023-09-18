package io.springbootweb.main.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        log.info("main page");
        model.addAttribute("paramTest", "test");
        return "main/main";
    }

}
