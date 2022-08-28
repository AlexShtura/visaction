package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Message;
import com.teachmeskills.visaction.repository.MessageRepo;
import com.teachmeskills.visaction.repository.UserRepo;
import com.teachmeskills.visaction.service.MessageService;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Override
    public void saveMessage(Message message, String login) {
        message.setAuthor(userRepo.findByUsername(login));
        messageRepo.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepo.deleteById(id);
    }

    @Override
    public List<Message> getAllUserMessages(String login) {
        List<Message> messages = messageRepo.findAllByUser_Username(login);
        //Collections.sort(messages);
        return messages;
    }

    @Override
    public Message getMessage(Long id) {
        return messageRepo.getById(id);
    }

    @Override
    public List<Message> findByCriteria(String tag, String text) {
        return messageRepo.findByTagContainingOrTextContaining(tag, text);
    }
}
