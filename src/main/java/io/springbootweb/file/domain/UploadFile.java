package io.springbootweb.file.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UploadFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(nullable = false)
    private String originalName;
    @Column(nullable = false)
    private String saveName;
    @Column(nullable = false)
    private String path;
    private String delYn;

    public void setId(Long id) {
        this.id = id;
    }

    @Builder
    public UploadFile(String originalName, String saveName, String path, String fileDelYn) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.path = path;
        this.delYn = fileDelYn;
    }
}
