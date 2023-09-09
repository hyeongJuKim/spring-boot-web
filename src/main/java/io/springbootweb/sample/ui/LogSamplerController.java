package io.springbootweb.sample.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogSamplerController {

    private final Logger log = LoggerFactory.getLogger(LogSamplerController.class);

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
