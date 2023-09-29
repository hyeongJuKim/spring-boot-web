package io.springbootweb.file.application;

import io.springbootweb.file.domain.FileRepository;
import io.springbootweb.file.domain.UploadFile;
import io.springbootweb.file.dto.FileDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class FileService {

    @Value("${spring.servlet.multipart.location}")
    private String fileRootPath;
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public UploadFile findById(Long fileId) {
        return fileRepository.findById(fileId).orElse(null);
    }

    public UploadFile saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String extension = StringUtils.getFilenameExtension(fileName);
        String fileFullPath = String.format("%s%s.%s", fileRootPath, UUID.randomUUID(), extension);

        file.transferTo(new File(fileFullPath));

        log.debug("file origin name: " + file.getOriginalFilename());
        log.debug("file pull path: " + fileFullPath);

        FileDTO fileDTO = FileDTO.builder()
                .originalName(file.getOriginalFilename())
                .saveName(UUID.randomUUID() + "." + extension)
                .path(fileFullPath)
                .build();

        return fileRepository.save(fileDTO.toFile());
    }

    public Resource loadFile(Long fileId) {

        Optional<UploadFile> file = fileRepository.findById(fileId);

        try {
            file.orElseThrow(() -> new FileNotFoundException("File not found"));
            UploadFile uploadFile = file.get();

            Path filePath = Paths.get(uploadFile.getPath()).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found: " + filePath.toUri());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteFileById(Long templateFileId) {
        UploadFile uploadFile = fileRepository.findById(templateFileId).orElse(null);
        if (uploadFile != null) {
            UploadFile file = uploadFile;
            fileRepository.delete(file);
            File logicalFile = new File(file.getPath());
            logicalFile.delete();
        }
    }
}
