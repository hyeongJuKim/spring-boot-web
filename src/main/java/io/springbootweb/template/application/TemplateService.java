package io.springbootweb.template.application;

import io.springbootweb.template.domain.Template;
import io.springbootweb.template.domain.TemplateRepository;
import io.springbootweb.template.dto.TemplateDTO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
public class TemplateService {
    @Value("${spring.servlet.multipart.location}")
    private String fileRootPath;
    private TemplateRepository templateRepository;

    public void saveTemplate(TemplateDTO.Request request) throws IOException {
        Template template = request.toTemplate();
        //Template save = templateRepository.save(template);
        this.uploadFile(fileRootPath, request.getTemplateFile());
    }

    private void uploadFile(String uploadDir, MultipartFile file) throws IOException {
        
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            int lastDotIndex = fileName.lastIndexOf(".");
            String extension = lastDotIndex > 0 ? fileName.substring(lastDotIndex + 1) : "";
            String fileFullPath = String.format("%s%s.%s", uploadDir, UUID.randomUUID(), extension);

            file.transferTo(new File(fileFullPath));

            log.debug("file origin name: " + file.getOriginalFilename());
            log.debug("file pull path: " + fileFullPath);
        }
    }

}
