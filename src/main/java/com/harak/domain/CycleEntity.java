package com.harak.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.harak.generics.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CYCLE")
public class CycleEntity implements BaseEntity<CycleEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CYCLE_NAME")
    @JsonProperty("cycle_name")
    private String cycleName;

    public CycleEntity() {
    }

    @Override
    public void update(CycleEntity source) {
        this.cycleName=source.cycleName;

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public CycleEntity createNewInstance() {
        CycleEntity cycleEntity= new CycleEntity();
        cycleEntity.update(cycleEntity);
        return cycleEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }
}
