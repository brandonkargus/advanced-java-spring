package platform.codingnomads.co.springmvc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("name", "Spring Developer!");
        return "greeting"; 
    }

    @GetMapping({"/practice"})
    public String practice(Model model) {
        model.addAttribute("n1", "This is me...");
        model.addAttribute("n2", "practicing...");
        model.addAttribute("n3", "Thymeleaf!!!");
        return "practice";
    }
}