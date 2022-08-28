package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Message;
import com.teachmeskills.visaction.service.MessageService;
import com.teachmeskills.visaction.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/contact")
public class MessageController {

    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/new-message")
    public String newMessage(Model model) {
        List<Message> allMessages = messageService.getAllMessages();
        model.addAttribute("message", new Message());
        return "new-message";
    }

    @PostMapping("/new-message")
    public String createMessage(@ModelAttribute("message") @Valid Message message,
                                BindingResult bindingResult,
                                Principal principal) {
        if (bindingResult.hasErrors()) {
            return "new-message";
        }
        messageService.saveMessage(message, principal.getName());
        logger.info("Message was created");
        return "redirect:/contact";
    }

    @GetMapping("/{id}")
    public String showMessage(@PathVariable("id") Long id, Model model, Principal principal) {
        model.addAttribute("user", userService.findByName(principal.getName()));
        model.addAttribute("messsage", messageService.getMessage(id));
        return "showMessage";
    }

    @PostMapping("/delete/{id}")
    public String deleteMessage(@PathVariable("id") Long id) {
        messageService.deleteMessage(id);
        return "redirect:/index";
    }
}