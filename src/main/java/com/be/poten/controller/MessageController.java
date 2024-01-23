package com.be.poten.controller;

import com.be.poten.dto.message.MessageRequestDto;
import com.be.poten.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping(value = "/api/message")
    public ResponseEntity<?> executeAndGetMessage(@RequestBody MessageRequestDto message) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", messageService.executeAndGetMessage(message));
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/api/clova-study")
    public ResponseEntity<?> executeClovaStudy() throws Exception {
//        HashMap<String, String> result = new HashMap<>();
//        result.put("result", );
        messageService.executeClovaStudy();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/api/message/{messageId}")
    public ResponseEntity<?> getMessage(@PathVariable String messageId) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", messageService.getMessage(messageId));
        return ResponseEntity.ok().body(result);
    }
}