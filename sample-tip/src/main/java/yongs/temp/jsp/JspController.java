package yongs.temp.jsp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class JspController {
    @GetMapping("/board")
    public String board(Model model)  {
        model.addAttribute("jspMessage", new JspMessage());
        return "board";
    }
    @GetMapping("/search")
    public String search()  {
        return "search";
    }

    @PostMapping("/boarding")
    public String posting(@ModelAttribute("jspMessage") JspMessage jspMessage, Model model)  {
        log.debug("message : " + jspMessage.getMessage());

        model.addAttribute("message", jspMessage.getMessage());

        return "board_result";
    }
    @GetMapping("/searching")
    public String searching(@RequestParam String keyword, Model model)  {
        log.debug("keyword : " + keyword);
        model.addAttribute("keyword", keyword);

        return "search_result";
    }
}
