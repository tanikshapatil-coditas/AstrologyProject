package com.example.Astrology.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@MappedSuperclass
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    private static final long serialVersionUID = 2051933567093349584L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name = "created_on", columnDefinition = "TIMESTAMP")
    private Instant createdOn = Instant.now();

    @JsonIgnore
    @Column(name = "updated_on", columnDefinition = "TIMESTAMP")
    private Instant updatedOn;

    @JsonIgnore
    @Column(insertable = false, updatable = true, name = "updated_by")
    private String updatedBy;

    @JsonIgnore
    @Column(insertable = true, updatable = false, name = "created_by")
    private String createdBy;

}