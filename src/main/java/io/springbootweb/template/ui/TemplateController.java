package io.springbootweb.template.ui;

import io.springbootweb.template.application.TemplateService;
import io.springbootweb.template.dto.TemplateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping(value = "")
    public String templates(Model model) {
        log.info("templates page");
        model.addAttribute("templates", templateService.findAll());

        return "templates/template_list";
    }

    @GetMapping(value = "/{templateId}")
    public String template(@PathVariable(name = "templateId") Long templateId, Model model) {
        log.info("template page");
        model.addAttribute("template", templateService.findById(templateId));

        return "templates/template_detail";
    }

    @GetMapping(value = "/template_regist")
    public String saveTemplatePage(@ModelAttribute TemplateDTO.Request templateDTO) {
        log.info("save templates page");

        return "templates/template_regist";
    }

    @PostMapping(value = "/template_regist")
    public String saveTemplate(@ModelAttribute TemplateDTO.Request templateDTO) throws Exception {
        log.info("save templates");
        templateService.saveTemplate(templateDTO);

        return "redirect:/templates";
    }

}
