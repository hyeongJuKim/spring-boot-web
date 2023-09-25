package io.springbootweb.file.application;

import io.springbootweb.file.domain.FileRepository;
import io.springbootweb.file.domain.UploadFile;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Value("${spring.servlet.multipart.location}")
    private String fileRootPath;
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
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

}
