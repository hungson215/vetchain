package edu.gatech.team7339.vetchain.controller;

import edu.gatech.team7339.vetchain.model.User;
import edu.gatech.team7339.vetchain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/{type}/{username}", method = RequestMethod.GET)
    public String showHomePage(@PathVariable("type") String type,
                               @PathVariable("username") String username,
                               ModelMap model) {
        User user = userRepo.findUserByUsername(username);
        if(user!=null) {
            if (type.equalsIgnoreCase("client")) {
                model.addAttribute("userInfo", user);
                return "client_home";
            } else {
                return "redirect:/"; // Fix this for doctor
            }
        }
        return "redirect:/";
    }
}
