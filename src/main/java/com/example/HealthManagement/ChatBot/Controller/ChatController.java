package com.example.HealthManagement.ChatBot.Controller;

import com.example.HealthManagement.ChatBot.RequestForChat.ChatRequest;
import com.example.HealthManagement.ChatBot.Service.ChatService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/chatGpt")
public class ChatController {

    private static final Logger logger =
            LoggerFactory.getLogger(ChatController.class);

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/healthCheck")
    public String healthCheck() {

        logger.info("Health Check Working");

        return "Working";
    }

    @PostMapping("/api/Version4/Chat/ChatWithGpt")
    public ResponseEntity<String> generateResponse(
            @RequestBody ChatRequest request
    ) {

        logger.info("Message Received");

        String response =
                chatService.getResponseFromAi(
                        request.getMessage()
                );

        return ResponseEntity.ok(response);
    }
}