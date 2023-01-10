package com.fitness.api.data.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CharacteristicEntity {

    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String value;

    @NotNull
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name="client_id")
    private ClientEntity client;

    @PrePersist
    void onCreate() {
        this.setCreationDate(LocalDateTime.now());
    }
}
