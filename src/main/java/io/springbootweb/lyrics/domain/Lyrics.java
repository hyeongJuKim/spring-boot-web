package io.springbootweb.lyrics.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Lyrics {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(nullable = false)
    private String lyricsName;
    @Column(nullable = false)
    private String lyrics;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String descriptions;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    @Builder
    public Lyrics(Long id, String lyricsName, String lyrics, String descriptions, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.lyricsName = lyricsName;
        this.lyrics = lyrics;
        this.descriptions = descriptions;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
