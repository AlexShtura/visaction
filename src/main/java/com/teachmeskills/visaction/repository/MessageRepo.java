package com.teachmeskills.visaction.repository;

import com.teachmeskills.visaction.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByTagContainingOrTextContaining(String tag, String text);

    List<Message> findAllByUser_Username(String login);

}
