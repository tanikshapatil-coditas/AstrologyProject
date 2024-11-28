package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationCreateDto {
    private Long id;
    private Date consultationDate;
    private Double fee;
    private Double amountPaid;
    private Double balance;
    private String notes;
}
