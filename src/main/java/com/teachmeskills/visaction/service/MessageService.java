package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.Message;

import java.util.List;

public interface MessageService {

    void saveMessage(Message message, String login);

    List<Message> getAllMessages();

    void deleteMessage(Long id);

    List<Message> getAllUserMessages(String login);

    Message getMessage(Long id);

    List<Message> findByCriteria(String tag, String text);
}
