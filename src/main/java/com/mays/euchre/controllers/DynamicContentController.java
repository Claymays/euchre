package com.mays.euchre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DynamicContentController {
    @GetMapping("/update")
    public String updateContent(@RequestParam String content, Model model) {
        model.addAttribute("content", content);
        return "fragments/content :: content";
    }
}
