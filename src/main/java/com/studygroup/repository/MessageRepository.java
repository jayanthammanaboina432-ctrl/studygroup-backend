package com.studygroup.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studygroup.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByGroupId(Long groupId);

}