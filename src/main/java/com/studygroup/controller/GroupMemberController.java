package com.studygroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studygroup.model.GroupMember;
import com.studygroup.repository.GroupMemberRepository;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupMemberController {

    @Autowired
    private GroupMemberRepository groupMemberRepository;

    // Join group
    @PostMapping("/join")
    public GroupMember joinGroup(@RequestBody GroupMember member) {
        return groupMemberRepository.save(member);
    }

    // View members of a group
    @GetMapping("/members/{groupId}")
    public List<GroupMember> getMembers(@PathVariable Long groupId) {
        return groupMemberRepository.findByGroupId(groupId);
    }
}