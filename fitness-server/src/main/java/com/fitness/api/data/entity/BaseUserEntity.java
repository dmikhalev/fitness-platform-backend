package com.fitness.api.data.entity;

import javax.persistence.*;

import com.fitness.api.dto.security.Role;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "base_user")
@Data
@NoArgsConstructor
public class BaseUserEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    private LocalDateTime creationDate;

    @PrePersist
    void onCreate() {
        this.setCreationDate(LocalDateTime.now());
    }
}
