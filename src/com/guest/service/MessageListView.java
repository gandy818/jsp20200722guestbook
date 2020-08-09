package com.guest.service;

import java.util.List;

import com.guest.model.Message;

public class MessageListView {

	private List<Message> messageList;

	
	public MessageListView(List<Message> messageList) {
		this.messageList = messageList;
		
		
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	
	
	
}
