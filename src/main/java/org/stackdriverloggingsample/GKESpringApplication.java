package org.stackdriverloggingsample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SpringBootApplication
@Slf4j
public class GKESpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GKESpringApplication.class, args);
    }
}

@RestController
@Slf4j
class SampleRestController {

    @GetMapping("/hello")
    public String hello() {
        log.info("Hello !!!!!!");
        return "Hello !!!!!!";
    }

    @GetMapping("hello/{name}")
    public String hello(@Valid @PathVariable("name") String name) {
        log.info("Test log!!!!!!!!!!!");
        return "Hello " + name;
    }
}
