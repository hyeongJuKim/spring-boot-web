package io.springbootweb.template.dto;

import io.springbootweb.file.domain.UploadFile;
import io.springbootweb.template.domain.Template;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class TemplateDTO {

    @Getter
    @Setter
    public class Request {
        private Long id;
        private String templateName;
        private String descriptions;
        private Long templateFileId;
        private MultipartFile templateFile;
        private String fileDelYn;

        public Template toTemplate() {
            return new Template(
                    id,
                    templateName,
                    descriptions,
                    null,
                    null,
                    null
            );
        }
    }

    public static class Response {
        private Long id;
        private String templateName;
        private String descriptions;
        private UploadFile uploadFile;
        private LocalDateTime createDate;
        private LocalDateTime modifiedDate;

        public Response(Long id, String templateName, String descriptions, UploadFile uploadFile,
                        LocalDateTime createDate, LocalDateTime modifiedDate) {
            this.id = id;
            this.templateName = templateName;
            this.descriptions = descriptions;
            this.uploadFile = uploadFile;
            this.createDate = createDate;
            this.modifiedDate = modifiedDate;
        }

        public static TemplateDTO.Response from(Template template) {
            return new TemplateDTO.Response(
                    template.getId(),
                    template.getTemplateName(),
                    template.getDescriptions(),
                    template.getUploadFile(),
                    template.getCreateDate(),
                    template.getModifiedDate()
            );
        }

        public Long getId() {
            return id;
        }

        public String getTemplateName() {
            return templateName;
        }

        public String getDescriptions() {
            return descriptions;
        }

        public UploadFile getUploadFile() {
            return uploadFile;
        }

        public LocalDateTime getCreateDate() {
            return createDate;
        }

        public LocalDateTime getModifiedDate() {
            return modifiedDate;
        }
    }
}
