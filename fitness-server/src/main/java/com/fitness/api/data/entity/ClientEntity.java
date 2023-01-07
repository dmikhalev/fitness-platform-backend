package com.fitness.api.data.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ClientEntity {
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

    @OneToMany(targetEntity = LicenseEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseEntity> licenseEntityList;

    @OneToMany(targetEntity = CharacteristicEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseEntity> characteristics;

    @PrePersist
    void onCreate() {
        this.setCreationDate(LocalDateTime.now());
    }
}
