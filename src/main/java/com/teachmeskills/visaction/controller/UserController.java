/*package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Role;
import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/profile")
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView editForm(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView.addObject("user", userService.findById(id));
        modelAndView.addObject("roles", Role.values());
        modelAndView.setViewName("user/edit-profile");
        return modelAndView;
    }

    @PostMapping
    public RedirectView save(@ModelAttribute User user, RedirectView redirectView) {
        userService.save(user);
        redirectView.setUrl("/profile");
        return redirectView;
    }
}*/
