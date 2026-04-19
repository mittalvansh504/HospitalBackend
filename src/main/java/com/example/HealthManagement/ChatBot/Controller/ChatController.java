package com.example.HealthManagement.ChatBot.Controller;


import com.example.HealthManagement.ChatBot.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/chatGpt")
public class ChatController {

    @Autowired
    public final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "Working";
    }

    @GetMapping("/api/version4/chat/chatWithGpt")
    public ResponseEntity<String> generateResponse(@RequestParam String message) {

        String response = chatService.getResponseFromAi(message);
        return ResponseEntity.ok(response);
    }

}
