package com.fitness.api.data.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "system_user")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
@NoArgsConstructor
public class SystemUserEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private Calendar birthday;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    private String email;

    private String phone;

    private LocalDateTime creationDate;



    @PrePersist
    void onCreate() {
        this.setCreationDate(LocalDateTime.now());
    }
}
