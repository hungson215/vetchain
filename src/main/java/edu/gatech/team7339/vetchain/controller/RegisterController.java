package edu.gatech.team7339.vetchain.controller;

import edu.gatech.team7339.vetchain.bindingObject.Register;
import edu.gatech.team7339.vetchain.model.User;
import edu.gatech.team7339.vetchain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @Autowired
    UserRepo userRepo;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute Register reg,
                                  ModelMap model,
                                  BindingResult result,
                                  RedirectAttributes redirect) {
        if(userRepo.existsUserByUsername(reg.getUsername())) {
            return "redirect:/";//Fix this later
        } else {
            userRepo.save(new User(reg.getUsername(),reg.getPassword(),reg.getEmail(),reg.getPhone()));
        }
        return "redirect:/";
    }
}
