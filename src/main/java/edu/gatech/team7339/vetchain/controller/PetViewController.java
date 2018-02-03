package edu.gatech.team7339.vetchain.controller;

import edu.gatech.team7339.vetchain.model.User;
import edu.gatech.team7339.vetchain.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Controller
public class PetViewController {
    @Autowired
    UserRepo userRepo;
    @RequestMapping("/{type}/{username}/pets")
    public String showPets(@PathVariable("type") String type,
                           @PathVariable("username") String username,
                           ModelMap model) {
        User user = userRepo.findUserByUsername(username);
        model.addAttribute("userInfo",user);
        return "petview";
    }
    @RequestMapping(value = "/{type}/{username}/pets/upload",method = RequestMethod.POST)
    public String showPets(@PathVariable("type") String type,
                           @PathVariable("username") String username,
                           @RequestParam("fileupload")MultipartFile file,
                           ModelMap model) {
        if (!file.isEmpty()) {
           String name = file.getOriginalFilename();
           try {
               byte[] bytes = file.getBytes();
               Files.write(new File(name).toPath(), bytes);
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        return "redirect:/"+type+"/"+username+"/pets";
    }
}
