package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Message;
import com.teachmeskills.visaction.repository.MessageRepo;
import com.teachmeskills.visaction.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepo messageRepo;

    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    @Override
    public List<Message> findByCriteria(String tag, String text) {

        return messageRepo.findByTagContainingOrTextContaining(tag,text);
    }

    @Override
    public void save(Message message) {
        messageRepo.save(message);
    }
}
