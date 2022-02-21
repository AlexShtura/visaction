package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("security/registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute User user, ModelAndView modelAndView) {
        User userFromDb = userService.findByName(user.getUsername());

        if (userFromDb != null) {
            modelAndView.addObject("message", "User exists!");
            modelAndView.setViewName("security/registration");
            return modelAndView;
        }

        userService.save(user);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
