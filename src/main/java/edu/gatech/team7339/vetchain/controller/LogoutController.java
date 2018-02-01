package edu.gatech.team7339.vetchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(ModelMap model) {
        return "redirect:/";
    }
}
