package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "coach")
@NoArgsConstructor
public class CoachEntity {

    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private LocalDate birthday;

    @NotNull
    private String firstName;

    @NotNull
    private String middleName;

    @NotNull
    private String lastName;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String profileDescription;

    @NotNull
    private int workExperience;

    @OneToOne(cascade = CascadeType.ALL,  optional = false, fetch = FetchType.LAZY)
    private BaseUserEntity baseUserEntity;

}
