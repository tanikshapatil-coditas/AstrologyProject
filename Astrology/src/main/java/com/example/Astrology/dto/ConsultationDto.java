package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {
    private Long id;
    private String name;
    private Date consultationDate;
    private Double fee;
    private Double amountPaid;
    private Double balance;
    private String notes;
    private Date nextConsultationDate;
    private Long clientId;
}