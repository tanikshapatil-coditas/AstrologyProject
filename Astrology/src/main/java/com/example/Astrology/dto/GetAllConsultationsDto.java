package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class GetAllConsultationsDto {
    private Long id;
    private String name;
    private Date consultationDate;
    private Double fee;
    private Double amountPaid;
    private Double balance;
    private String notes;
    private Date nextConsultationDate;
    private Long clientId;

    public GetAllConsultationsDto() {

    }
}
