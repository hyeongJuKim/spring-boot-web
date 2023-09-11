package io.springbootweb.template.application;

import io.springbootweb.template.domain.Template;
import io.springbootweb.template.domain.TemplateRepository;
import io.springbootweb.template.dto.TemplateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TemplateService {
    private final Logger log = LoggerFactory.getLogger(TemplateService.class);
    private TemplateRepository templateRepository;

    public void saveTemplate(TemplateDTO.Request request) {
        Template template = request.toTemplate();
        templateRepository.save(template);
    }
}
