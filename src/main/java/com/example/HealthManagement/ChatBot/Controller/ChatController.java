package com.example.HealthManagement.ChatBot.Controller;


import com.example.HealthManagement.ChatBot.Service.ChatService;
import com.example.HealthManagement.Patient.Controller.PatientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/chatGpt")
public class ChatController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(PatientController.class);

    @Autowired
    public final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/healthCheck")
    public String healthCheck(){
        logger.info("Correct");
        return "Working";
    }

    @GetMapping("/api/version4/chat/chatWithGpt")
    public ResponseEntity<String> generateResponse(@RequestParam String message) {
        logger.error("Not getting response");
        String response = chatService.getResponseFromAi(message);
        return ResponseEntity.ok(response);
    }

}
