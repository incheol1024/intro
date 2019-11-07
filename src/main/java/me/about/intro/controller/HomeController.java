package me.about.intro.controller;

import me.about.intro.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/post")
    public String post() {
        return "post";
    }


    @GetMapping("/viewTest")
    public String viewTest(Model model) {
        model.addAttribute("message", homeService.getMessage());
        return "view-test";
    }


}
