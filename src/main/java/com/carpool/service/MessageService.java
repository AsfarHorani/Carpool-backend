package com.carpool.service;

import com.carpool.model.Message;

public interface MessageService {
	public Message sendMessage(Message converstion);
	public void deleteMessage(long messageId);
    
}
