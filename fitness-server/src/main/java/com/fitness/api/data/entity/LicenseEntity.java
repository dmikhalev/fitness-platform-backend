package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "license")
@NoArgsConstructor
public class LicenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime finishDate;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;
}
