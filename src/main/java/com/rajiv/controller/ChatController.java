package com.rajiv.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.rajiv.model.ChatMessage;

@Controller
public class ChatController {
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	
	public ChatMessage register(@Payload ChatMessage chatmessage,SimpMessageHeaderAccessor headerAccessor){
	headerAccessor.getSessionAttributes().put("username", chatmessage.getSender());
	return chatmessage;
	
	}
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatmessage) {
		return chatmessage;
	}
	}


