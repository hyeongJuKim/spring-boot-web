package io.springbootweb.template.ui;

import io.springbootweb.template.application.TemplateService;
import io.springbootweb.template.domain.Template;
import io.springbootweb.template.dto.TemplateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    private final Logger log = LoggerFactory.getLogger(io.springbootweb.main.ui.MainController.class);
    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping(value = "")
    public String templates(Model model) {
        log.info("templates page");
        model.addAttribute("templates", new Template());
        return "templates/templates";
    }

    @PostMapping(value = "")
    public String saveTemplate(@ModelAttribute TemplateDTO.Request templateDTO) {
        log.info("save templates");
        templateService.saveTemplate(templateDTO);
        return "redirect:/templates";
    }

}
