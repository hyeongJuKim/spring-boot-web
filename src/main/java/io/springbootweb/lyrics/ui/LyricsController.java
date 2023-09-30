package io.springbootweb.lyrics.ui;

import io.springbootweb.lyrics.application.LyricsService;
import io.springbootweb.lyrics.dto.LyricsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/lyrics")
public class LyricsController {

    private final LyricsService lyricsService;

    public LyricsController(LyricsService lyricsService) {
        this.lyricsService = lyricsService;
    }

    @GetMapping
    public String lyrics(Model model) {
        log.info("lyrics page");
        model.addAttribute("lyrics", lyricsService.findAll());

        return "lyrics/lyrics_list";
    }

    @GetMapping(value = "/{lyricsId}")
    public String lyrics(@PathVariable(name = "lyricsId") Long lyricsId, Model model) {
        log.info("lyrics page");
        model.addAttribute("lyrics", lyricsService.findById(lyricsId));

        return "lyrics/lyrics_detail";
    }

    @GetMapping(value = "/regist")
    public String saveLyricsPage(@ModelAttribute LyricsDTO.Request lyricsDTO) {
        log.info("save lyrics page");

        return "lyrics/lyrics_regist";
    }

    @PostMapping
    public String postLyrics(@ModelAttribute LyricsDTO.Request lyricsDTO) throws Exception {
        log.info("POST lyrics");
        lyricsService.save(lyricsDTO);

        return "redirect:/lyrics";
    }

    @PutMapping(value = "/{lyricsId}")
    public String putLyrics(@PathVariable(name = "lyricsId") Long lyricsId,
                              @ModelAttribute LyricsDTO.Request lyricsDTO) throws Exception {
        log.info("PUT lyrics");
        lyricsService.save(lyricsDTO);

        return "redirect:/lyrics";
    }

    @GetMapping(value = "/edit/{lyricsId}")
    public String editLyricsPage(@PathVariable(name = "lyricsId") Long lyricsId, Model model) {
        log.info("edit lyrics page");
        model.addAttribute("lyrics", lyricsService.findById(lyricsId));

        return "lyrics/lyrics_regist";
    }

}
