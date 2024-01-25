package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.User;

import java.time.LocalDateTime;

public record UserDTO(String email, String role, LocalDateTime createdAt, LocalDateTime lastLogin, boolean activated){
    public UserDTO(User user){
        this(user.getEmail(), user.getRole().name(), user.getCreatedAt(), user.getLastLogin(), user.isActivated());
    }
}
