package edu.gatech.team7339.vetchain.controller;

import edu.gatech.team7339.vetchain.bindingObject.Login;
import edu.gatech.team7339.vetchain.bindingObject.Register;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAndRegController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(ModelMap model) {
        model.addAttribute("loginInfo",new Login());
        model.addAttribute("regInfo",new Register());
        return "index";
    }
}
