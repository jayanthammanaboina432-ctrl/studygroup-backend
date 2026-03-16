package com.studygroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studygroup.model.StudyGroup;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

}