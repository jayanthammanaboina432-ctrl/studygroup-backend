package com.studygroup.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studygroup.model.GroupMember;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    List<GroupMember> findByGroupId(Long groupId);

}