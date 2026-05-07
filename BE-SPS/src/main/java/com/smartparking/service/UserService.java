package com.smartparking.service;

import com.smartparking.dto.UserResponse;
import com.smartparking.entity.User;
import com.smartparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // GET ALL + SEARCH (merge feature mới)
    public List<UserResponse> getAll(String keyword) {
        List<User> users;

        if (keyword != null && !keyword.trim().isEmpty()) {
            users = repo.searchUsers(keyword.trim());
        } else {
            users = repo.findAll();
        }

        return users.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public UserResponse getById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToResponse(user);
    }

    // CREATE
    public User create(User user) {
        return repo.save(user);
    }

    // UPDATE
    public User update(Long id, User userDetails) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setCardId(userDetails.getCardId());
        user.setRole(userDetails.getRole());

        user.setEmail(userDetails.getEmail());

        return repo.save(user);
    }

    // DELETE
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        repo.deleteById(id);
    }

    // Mapper
    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getRole().name(),
                user.getCardId(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}