package com.studygroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studygroup.model.StudyGroup;
import com.studygroup.repository.StudyGroupRepository;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {

    @Autowired
    private StudyGroupRepository groupRepository;

    // Create study group
    @PostMapping("/create")
    public StudyGroup createGroup(@RequestBody StudyGroup group) {
        return groupRepository.save(group);
    }

    // Get all study groups
    @GetMapping
    public List<StudyGroup> getAllGroups() {
        return groupRepository.findAll();
    }
}