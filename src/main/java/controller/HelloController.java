package controller;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootConfiguration
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String showHello() {
        return "hello";
    }
}
