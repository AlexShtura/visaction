package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();
    List<Message> findByCriteria(String tag, String text);
    void save(Message message);
}
