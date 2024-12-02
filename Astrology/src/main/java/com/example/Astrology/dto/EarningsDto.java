package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarningsDto {
    private Double monthlyEarning;
    private Double amountPaid;
    private Double balance;

}
