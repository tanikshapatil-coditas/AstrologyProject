package com.example.Astrology.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation_date", nullable = false)
    @NotNull(message = "Consultation date is required")
    @FutureOrPresent(message = "Consultation date must be in the present or future")
    private Date consultationDate;

    @Column(name = "charges", nullable = false)
    @NotNull(message = "Charges are required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Charges must be greater than zero")
    private Double charges;

    @Column(name = "balance", nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be zero or positive")
    private Double balance;

    @Column(name = "notes", length = 500)
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
