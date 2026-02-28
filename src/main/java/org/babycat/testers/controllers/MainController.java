package org.babycat.testers.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");

        mv.addObject("data", "hello! this is working it!");

        return mv;
    }
}
