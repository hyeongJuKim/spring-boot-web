package io.springbootweb.sample.domain;

import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader {
    private final CoffeeRepository coffeeRepository;
    public SampleDataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        coffeeRepository.saveAll(List.of(
                new Coffee("아아"),
                new Coffee("콜드브루"),
                new Coffee("카페라뗴")
        ));
    }
}
