package com.carpool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpool.model.Conversation;

public interface ConversationRepository  extends JpaRepository<Conversation,Long> {

}
