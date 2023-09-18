package io.springbootweb.template.dto;

import io.springbootweb.file.domain.File;
import io.springbootweb.template.domain.Template;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class TemplateDTO {

    @Getter
    @Setter
    public class Request {
        private String templateName;
        private String descriptions;
        private MultipartFile templateFile;

        public Template toTemplate() {
            return new Template(null, templateName, descriptions,
                    new File(null,
                            templateFile.getResource().getFilename(),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()),
                            "/file/templates/"
                    ));
        }
    }

}
