package io.springbootweb.lyrics.domain;

import io.springbootweb.common.tld.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Lyrics extends BaseEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    private String lyricsName;

    @Column(nullable = false, length = 4000)
    private String lyrics;

    @Column(nullable = false, length = 4000)
    private String descriptions;

    @Builder
    public Lyrics(Long id, String lyricsName, String lyrics, String descriptions) {
        this.id = id;
        this.lyricsName = lyricsName;
        this.lyrics = lyrics;
        this.descriptions = descriptions;
    }
}
