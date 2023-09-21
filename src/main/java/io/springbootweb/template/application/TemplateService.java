package io.springbootweb.template.application;

import io.springbootweb.file.domain.FileRepository;
import io.springbootweb.file.dto.FileDTO;
import io.springbootweb.template.domain.Template;
import io.springbootweb.template.domain.TemplateRepository;
import io.springbootweb.template.dto.TemplateDTO;
import java.io.File;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@Transactional
public class TemplateService {
    private final FileRepository fileRepository;
    private final TemplateRepository templateRepository;

    public TemplateService(FileRepository fileRepository, TemplateRepository templateRepository) {
        this.fileRepository = fileRepository;
        this.templateRepository = templateRepository;
    }
    @Value("${spring.servlet.multipart.location}")
    private String fileRootPath;

    @Transactional
    public void saveTemplate(TemplateDTO.Request templateRequest) throws Exception {

        Template templateEntity = templateRequest.toTemplate();

        MultipartFile file = templateRequest.getTemplateFile();
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(fileName);
            String fileFullPath = String.format("%s%s.%s", fileRootPath, UUID.randomUUID(), extension);

            file.transferTo(new File(fileFullPath));

            log.debug("file origin name: " + file.getOriginalFilename());
            log.debug("file pull path: " + fileFullPath);

            FileDTO fileDTO  = FileDTO.builder()
                    .originalName(file.getOriginalFilename())
                    .saveName(UUID.randomUUID() + "." + extension)
                    .path(fileFullPath)
                    .build();

            UploadFile savedUploadFile = fileRepository.save(fileDTO.toFile());

            log.debug("saved file id: "+ savedUploadFile.getId());

            templateEntity.setUploadFile(savedUploadFile);
        }
        Template save = templateRepository.save(templateEntity);

        if (save == null) {
            throw new Exception("저장에 실패하였습니다.");
        }
    }

    public List<Template> selectList() {
        return templateRepository.findAll();
    }
}
