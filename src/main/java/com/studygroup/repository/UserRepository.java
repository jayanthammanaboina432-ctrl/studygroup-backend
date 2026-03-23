package com.studygroup.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studygroup.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
}