package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "video")
@NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String link;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private TrainingProgramEntity trainingProgramEntity;

    public VideoEntity(String link, String title, String description, TrainingProgramEntity trainingProgramEntity) {
        this.link = link;
        this.title = title;
        this.description = description;
        this.trainingProgramEntity = trainingProgramEntity;
    }
}
