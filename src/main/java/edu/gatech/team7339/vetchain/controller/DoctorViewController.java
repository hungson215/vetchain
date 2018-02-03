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
public class DoctorViewController {
    @Autowired
    UserRepo userRepo;
    @RequestMapping(value = "/{type}/{id}/doctors",method = RequestMethod.GET)
    public String showDoctorView(@PathVariable("type") String type,
                                 @PathVariable("id") int id,
                                 ModelMap model) {
        User u = userRepo.findUserById(id);
        if(u !=null){
            model.addAttribute("userInfo",u);
            return "doctorview";
        }
        return "redirect:/";
    }
}
