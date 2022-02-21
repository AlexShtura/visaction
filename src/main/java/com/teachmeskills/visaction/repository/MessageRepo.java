package com.teachmeskills.visaction.repository;

import com.teachmeskills.visaction.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByTagContainingOrTextContaining(String tag, String text);

}
