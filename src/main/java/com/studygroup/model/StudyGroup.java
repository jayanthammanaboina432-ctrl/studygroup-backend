package com.studygroup.model;

import jakarta.persistence.*;

@Entity
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private String subject;
    private String description;
    private Long createdBy;
    private String createdByName;   // ← new field
    private boolean isPrivate;      // ← new field

    public StudyGroup() {}

    public Long getId() { return id; }
    public String getGroupName() { return groupName; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public Long getCreatedBy() { return createdBy; }
    public String getCreatedByName() { return createdByName; }
    public boolean isPrivate() { return isPrivate; }

    public void setId(Long id) { this.id = id; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    public void setCreatedByName(String createdByName) { this.createdByName = createdByName; }
    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }
}