package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "training_program")
@NoArgsConstructor
public class TrainingProgramEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String type;

    @NotNull
    private Boolean isReleased;

    @NotNull
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private CoachEntity coach;

    @OneToMany(mappedBy = "trainingProgramEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VideoEntity> videos;
}
