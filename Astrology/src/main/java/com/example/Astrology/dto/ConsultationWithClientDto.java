package com.example.Astrology.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationWithClientDto {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    private String address;
    private Integer age;
    private String contact;
    private Date consultationDate;
    private Double fee;
    private Double amountPaid;
    private Double balance;
    private String notes;
    private Date nextConsultationDate;
    private Long clientId;
}
