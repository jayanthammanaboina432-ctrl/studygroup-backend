package com.studygroup.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import com.studygroup.model.Message;
import com.studygroup.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Send message via REST + broadcast via WebSocket
    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        Message saved = messageRepository.save(message);
        // Broadcast to all subscribers of this group
        messagingTemplate.convertAndSend(
            "/topic/group/" + message.getGroupId(), saved
        );
        return saved;
    }

    // WebSocket message handler
    @MessageMapping("/chat/{groupId}")
    public void handleWebSocketMessage(
        @DestinationVariable Long groupId,
        @Payload Message message
    ) {
        Message saved = messageRepository.save(message);
        messagingTemplate.convertAndSend("/topic/group/" + groupId, saved);
    }

    // Get messages of a group
    @GetMapping("/group/{groupId}")
    public List<Message> getMessages(@PathVariable Long groupId) {
        return messageRepository.findByGroupId(groupId);
    }
}