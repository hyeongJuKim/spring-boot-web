package io.springbootweb.lyrics.dto;

import io.springbootweb.lyrics.domain.Lyrics;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class LyricsDTO {

    @Getter
    @Setter
    public class Request {
        private Long id;
        private String lyricsName;
        private String lyrics;
        private String descriptions;

        public Lyrics toLyrics() {
            return new Lyrics(
                    id,
                    lyricsName,
                    lyrics,
                    descriptions
            );
        }
    }

    public static class Response {
        private Long id;
        private String lyricsName;
        private String lyrics;
        private String descriptions;
        private LocalDateTime createDate;
        private LocalDateTime modifiedDate;

        public Response(Long id, String lyricsName, String lyrics, String descriptions, LocalDateTime createDate, LocalDateTime modifiedDate) {
            this.id = id;
            this.lyricsName = lyricsName;
            this.lyrics = lyrics;
            this.descriptions = descriptions;
            this.createDate = createDate;
            this.modifiedDate = modifiedDate;
        }

        public static LyricsDTO.Response from(Lyrics lyrics) {
            return new LyricsDTO.Response(
                    lyrics.getId(),
                    lyrics.getLyricsName(),
                    lyrics.getLyrics(),
                    lyrics.getDescriptions(),
                    lyrics.getCreateDate(),
                    lyrics.getModifiedDate()
            );
        }

        public Long getId() {
            return id;
        }

        public String getLyricsName() {
            return lyricsName;
        }

        public String getLyrics() {
            return lyrics;
        }

        public String getDescriptions() {
            return descriptions;
        }

        public LocalDateTime getCreateDate() {
            return createDate;
        }

        public LocalDateTime getModifiedDate() {
            return modifiedDate;
        }
    }
}
