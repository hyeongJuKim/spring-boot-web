package io.springbootweb.file.dto;

import io.springbootweb.file.domain.UploadFile;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDTO {
    private Long id;
    private String originalName;
    private String saveName;
    private String path;
    private String fileDelYn;

    public UploadFile toFile() {
        return UploadFile.builder()
                .originalName(this.originalName)
                .saveName(this.saveName)
                .path(this.path)
                .fileDelYn(this.fileDelYn)
                .build();
    }

    @Builder
    public FileDTO(Long id, String originalName, String saveName, String path) {
        this.id = id;
        this.originalName = originalName;
        this.saveName = saveName;
        this.path = path;
    }

}
