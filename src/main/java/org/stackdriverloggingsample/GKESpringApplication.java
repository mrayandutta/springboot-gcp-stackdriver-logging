package org.stackdriverloggingsample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    private String getTimeString()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
        String timeString = simpleformat.format(cal.getTime());
        return timeString;
    }

    @GetMapping("/hello")
    public String hello() {
        String response = "Hello !!!!!!,timestamp is :"+ getTimeString();
        log.info(response);
        return response;
    }

    @GetMapping("hello/{name}")
    public String hello(@Valid @PathVariable("name") String name) {
        String response = "Test log!!!!!!!!!!!,timestamp is :"+ getTimeString();
        log.info(response);
        return response;
    }
}
