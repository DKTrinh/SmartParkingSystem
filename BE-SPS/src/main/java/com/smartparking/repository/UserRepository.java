package com.smartparking.repository;

import com.smartparking.entity.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        SELECT u FROM User u
        WHERE u.name LIKE %:keyword%
           OR u.cardId LIKE %:keyword%
    """)
    List<User> searchUsers(@Param("keyword") String keyword);

    Optional<User> findByCardId(String cardId);
}