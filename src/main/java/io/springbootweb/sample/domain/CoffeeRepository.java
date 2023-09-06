package io.springbootweb.sample.domain;

import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {}
