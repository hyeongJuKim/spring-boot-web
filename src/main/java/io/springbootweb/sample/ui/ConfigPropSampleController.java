package io.springbootweb.sample.ui;

import io.springbootweb.sample.domain.Droid;
import io.springbootweb.sample.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configProp")
public class ConfigPropSampleController {
    private final Greeting greeting;
    private final Droid droid;

    public ConfigPropSampleController(Greeting greeting, Droid droid) {
        this.greeting = greeting;
        this.droid = droid;
    }

    /**
     * config properties 방식 1
     * POJO에 애노테이션을 등록하여 사용한다.
     *
     * @return
     */
    @GetMapping("/greeting")
    String getGreetingName() {
        return greeting.getName();
    }

    /**
     * config properties 방식 1
     * POJO에 애노테이션을 등록하여 사용한다.
     *
     * @return
     */
    @GetMapping("/greeting/coffee")
    String getCoffee() {
        return greeting.getCoffee();
    }

    /**
     * config properties 방식 2
     * SpringBootWebApplication에 Bean으로 등록하여 사용한다.
     *
     * @return
     */
    @GetMapping("/droid")
    Droid getDroid() {
        return droid;
    }

}
