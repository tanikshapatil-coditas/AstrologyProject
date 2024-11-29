package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EarningsDto {
    private double totalEarnings;
    private double totalPending;

    public EarningsDto(double totalEarnings, double totalPending) {
        this.totalEarnings = totalEarnings;
        this.totalPending = totalPending;
    }


}

