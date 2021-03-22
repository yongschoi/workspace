package yongs.temp.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class GreetingController {
    @PostMapping("/greeting")
    public String greeting(@ModelAttribute Greeting greeting, Model model)  {
        log.debug("name : " + greeting.getName());
        log.debug("message : " + greeting.getMessage());

        model.addAttribute("greeting", greeting);
        return "result";
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
}
