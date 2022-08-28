package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Role;
import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    //private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list-of-users")
    public ModelAndView userList(ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("admin/list-of-users");
        return modelAndView;
    }

    @GetMapping("/list-of-users/edit-user/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("user", userService.findById(id));
        modelAndView.addObject("roles", Role.values());
        modelAndView.setViewName("admin/edit-user");
        return modelAndView;
    }

    @PostMapping("/list-of-users/edit-user/{id}")
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        String message = (user.isActive() ? "Updated " : "Deleted ") + " user <b>" + user.getFirstName() + " " + user.getLastName() + "</b>.";
        RedirectView redirectView = new RedirectView("/list-of-users", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }
}
