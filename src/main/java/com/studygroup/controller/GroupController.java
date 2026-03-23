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

    @PostMapping("/create")
    public StudyGroup createGroup(@RequestBody StudyGroup group) {
        return groupRepository.save(group);
    }

    @GetMapping
    public List<StudyGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public StudyGroup updateGroup(@PathVariable Long id, @RequestBody StudyGroup updatedGroup) {
        StudyGroup group = groupRepository.findById(id).orElseThrow();
        group.setGroupName(updatedGroup.getGroupName());
        group.setSubject(updatedGroup.getSubject());
        group.setDescription(updatedGroup.getDescription());
        return groupRepository.save(group);
    }
}