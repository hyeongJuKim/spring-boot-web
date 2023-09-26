package io.springbootweb.template.domain;


import io.springbootweb.file.domain.UploadFile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Template {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String templateName;
    private String descriptions;
    @OneToOne
    @JoinColumn(name = "upload_file_id")
    private UploadFile uploadFile;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    @Builder
    public Template(Long id, String templateName, String descriptions, UploadFile uploadFile, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.templateName = templateName;
        this.descriptions = descriptions;
        this.uploadFile = uploadFile;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public void setUploadFile(UploadFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public UploadFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFileId(UploadFile uploadFile) {
        this.uploadFile = uploadFile;
    }
}


