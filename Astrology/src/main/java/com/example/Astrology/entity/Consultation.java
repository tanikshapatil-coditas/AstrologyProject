package com.example.Astrology.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consultation_date", nullable = false)
    @NotNull(message = "Consultation date is required")
    private Date consultationDate;

    @Column(name = "next_consultation_date", nullable = false)
    @NotNull(message = "Next consultation date is required")
    @FutureOrPresent(message = "Next consultation date must be in the present or in the future")
    private Date nextConsultationDate;

    @Column(name = "fee", nullable = false)
    @NotNull(message = "Fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Fee must be greater than zero")
    private Double fee;


    @Column(name = "amount_paid", nullable = false)
    @NotNull(message = "Amount paid is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Amount paid must be zero or positive")
    private Double amountPaid;


    @Column(name = "balance", nullable = false)
    private Double balance;


    @Column(name = "notes", length = 500)
    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;


    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    @PrePersist
    protected void onCreate(){
        this.consultationDate = new Date();
        this.balance = this.fee - this.amountPaid;
    }

    @PreUpdate
    public void calculateBalance() {
        this.balance = this.fee - this.amountPaid;
    }
}