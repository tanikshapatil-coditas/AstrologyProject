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
    private Date consultationDate;
    private Double charges;
    private Double balance;
    private String notes;
    private Long clientId;
}