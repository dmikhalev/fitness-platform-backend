package com.fitness.api.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@DiscriminatorValue("CC")
public class ClientEntity {
    @Id
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private long id;

    @OneToMany(targetEntity = LicenseEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseEntity> licenseEntityList;

    @OneToMany(targetEntity = CharacteristicEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LicenseEntity> characteristics;
}
