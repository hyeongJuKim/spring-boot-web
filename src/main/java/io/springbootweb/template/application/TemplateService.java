package io.springbootweb.template.application;


import io.springbootweb.file.application.FileService;
import io.springbootweb.file.domain.UploadFile;
import io.springbootweb.template.domain.Template;
import io.springbootweb.template.domain.TemplateRepository;
import io.springbootweb.template.dto.TemplateDTO;
import jakarta.persistence.EntityNotFoundException;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
public class TemplateService {
    private final FileService fileService;
    private final TemplateRepository templateRepository;

    public TemplateService(FileService fileService, TemplateRepository templateRepository) {
        this.fileService = fileService;
        this.templateRepository = templateRepository;
    }

    @Value("${spring.servlet.multipart.location}")
    private String fileRootPath;

    @Transactional
    public void saveTemplate(TemplateDTO.Request templateRequest) throws Exception {
        Template templateEntity = templateRequest.toTemplate();
        MultipartFile file = templateRequest.getTemplateFile();

        Long fileId = templateRequest.getTemplateFileId();
        String fileDelYn = templateRequest.getFileDelYn();
        boolean isFileUpdate = !"Y".equals(fileDelYn) && fileId > 0;
        if ("Y".equals(fileDelYn) && fileId > 0) {
            fileService.deleteFileById(fileId);
        }

        if (!file.isEmpty() && !isFileUpdate) {
            UploadFile savedUploadFile = fileService.saveFile(file);
            templateEntity.setUploadFile(savedUploadFile);
        } else if (file.isEmpty() && isFileUpdate) {
            templateEntity.setUploadFile(fileService.findById(fileId));
        }

        Template save = templateRepository.save(templateEntity);

        if (save == null) {
            throw new Exception("저장에 실패하였습니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<TemplateDTO.Response> findAll() {
        List<Template> templates = templateRepository.findAll();
        return templates.stream()
                .map(TemplateDTO.Response::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TemplateDTO.Response findById(Long templateId) {
        Optional<Template> template = templateRepository.findById(templateId);
        template.orElseThrow(() -> new EntityNotFoundException("템플릿을 찾지못했습니다."));
        return TemplateDTO.Response.from(template.get());
    }
}
