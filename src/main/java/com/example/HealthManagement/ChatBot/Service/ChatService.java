package com.example.HealthManagement.ChatBot.Service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Value("${spring.ai.google.genai.api-key}")
    private String apiKey;


    private final ChatClient chatClient;


    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getResponseFromAi(String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}
