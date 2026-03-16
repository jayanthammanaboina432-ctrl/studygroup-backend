package com.studygroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studygroup.model.Message;
import com.studygroup.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // Send message
    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    // Get messages of a group
    @GetMapping("/group/{groupId}")
    public List<Message> getMessages(@PathVariable Long groupId) {
        return messageRepository.findByGroupId(groupId);
    }
}