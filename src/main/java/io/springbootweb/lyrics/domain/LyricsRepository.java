package io.springbootweb.lyrics.domain;

import io.springbootweb.template.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LyricsRepository extends JpaRepository<Lyrics, Long> {

}
