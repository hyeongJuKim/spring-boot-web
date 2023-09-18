package io.springbootweb.sample.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogSamplerController {

    /** log 테스트 */
    @RequestMapping(value = "/sample/log")
    public String logSample() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "";
    }
}
