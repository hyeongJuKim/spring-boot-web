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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
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

    @GetMapping(value = "/regist")
    public String saveTemplatePage(@ModelAttribute TemplateDTO.Request templateDTO) {
        log.info("save templates page");

        return "templates/template_regist";
    }

    @PostMapping
    public String postTemplate(@ModelAttribute TemplateDTO.Request templateDTO) throws Exception {
        log.info("POST templates");
        templateService.saveTemplate(templateDTO);

        return "redirect:/templates";
    }

    @PutMapping(value = "/{templateId}")
    public String putTemplate(@PathVariable(name = "templateId") Long templateId,
                              @ModelAttribute TemplateDTO.Request templateDTO) throws Exception {
        log.info("PUT templates");
        templateService.saveTemplate(templateDTO);

        return "redirect:/templates";
    }

    @GetMapping(value = "/edit/{templateId}")
    public String editTemplatePage(@PathVariable(name = "templateId") Long templateId, Model model) {
        log.info("edit templates page");
        model.addAttribute("template", templateService.findById(templateId));

        return "templates/template_regist";
    }


}
