package edu.gatech.team7339.vetchain.controller;

import edu.gatech.team7339.vetchain.bindingObject.Login;
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
public class LoginController {
    @Autowired
    UserRepo userRepo;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@ModelAttribute Login login,
                               ModelMap model,
                               BindingResult result,
                               RedirectAttributes redirect) {
        User u = userRepo.findUserByUsernameAndPassword(login.getUsername(),login.getPassword());
        if(u != null){
            return "redirect:/" + u.getType() + "/" + u.getUsername();
        }
        return "redirect:/";
    }
}
