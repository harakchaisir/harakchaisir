package com.harak.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.context.annotation.Prototype;

import javax.persistence.*;

@Entity
@Table(name = "codon")
@SequenceGenerator(name = "CODON_ID_SEQ", initialValue = 1,allocationSize = 1)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodonEntity {
    @Id
    @Column(name = "CODON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CODON_ID_SEQ")
    private Long codonId;

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("CREATED_AT")
    @Column(name = "CREATED_AT")
    private String createdAt;

    @Column(name = "CREATED_BY")
    @JsonProperty("CREATED_BY")
    private Long createdBy;

    @Column(name = "UPDATED_AT")
    @JsonProperty("UPDATED_AT")
    private String updatedAt;

    @Column(name = "UPDATED_BY")
    @JsonProperty("UPDATED_BY")
    private Long updatedBy;

    @Column(name = "OLIGO_ONE_SEQUENCE")
    @JsonProperty("OLIGO_ONE_SEQUENCE")
    private String oligoOneSequence;

    @Column(name = "OLIGO_ONE_BATCH_NAME")
    @JsonProperty("OLIGO_ONE_BATCH_NAME")
    private String oligoOneBatchName;

    @Column(name = "OLIGO_ONE_ISO_MW")
    @JsonProperty("OLIGO_ONE_ISO_MW")
    private String oligoOneIsoMw;

    @Column(name = "STATUS")
    @JsonProperty("STATUS")
    private String status;

    @Column(name = "WELLS_ID")
    @JsonProperty("WELLS_ID")
    private Long wellId;

    @Column(name = "OLIGO_TWO_ISO_MW")
    @JsonProperty("OLIGO_TWO_ISO_MW")
    private String oligoTwoIsoMw;

    @Column(name = "PLATE_ID")
    @JsonProperty("PLATE_ID")
    private Long plateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getOligoOneSequence() {
        return oligoOneSequence;
    }

    public void setOligoOneSequence(String oligoOneSequence) {
        this.oligoOneSequence = oligoOneSequence;
    }

    public String getOligoOneBatchName() {
        return oligoOneBatchName;
    }

    public void setOligoOneBatchName(String oligoOneBatchName) {
        this.oligoOneBatchName = oligoOneBatchName;
    }

    public String getOligoOneIsoMw() {
        return oligoOneIsoMw;
    }

    public void setOligoOneIsoMw(String oligoOneIsoMw) {
        this.oligoOneIsoMw = oligoOneIsoMw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getWellId() {
        return wellId;
    }

    public void setWellId(Long wellId) {
        this.wellId = wellId;
    }

    public String getOligoTwoIsoMw() {
        return oligoTwoIsoMw;
    }

    public void setOligoTwoIsoMw(String oligoTwoIsoMw) {
        this.oligoTwoIsoMw = oligoTwoIsoMw;
    }

    public Long getPlateId() {
        return plateId;
    }

    public void setPlateId(Long plateId) {
        this.plateId = plateId;
    }

    public Long getCodonId() {
        return codonId;
    }

    public void setCodonId(Long codonId) {
        this.codonId = codonId;
    }
}
