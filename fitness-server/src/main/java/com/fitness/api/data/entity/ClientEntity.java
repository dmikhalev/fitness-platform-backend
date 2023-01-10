package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private LocalDate birthday;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL,  optional = false, fetch = FetchType.LAZY)
    private BaseUserEntity baseUserEntity;

    @OneToMany(targetEntity = LicenseEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseEntity> licenseEntityList;

    @OneToMany(targetEntity = CharacteristicEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CharacteristicEntity> characteristics;
}
