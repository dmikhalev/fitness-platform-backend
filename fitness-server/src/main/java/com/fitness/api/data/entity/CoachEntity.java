package com.fitness.api.data.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "coach")
@DiscriminatorValue("BA")
public class CoachEntity extends SystemUserEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String profileDescription;

    @NotNull
    private int workExperience;
}
