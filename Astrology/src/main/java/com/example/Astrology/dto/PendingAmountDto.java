package com.example.Astrology.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PendingAmountDto {
    private Long clientId;
    private String clientName;
    private double pendingAmount;

    public PendingAmountDto(Long clientId, String clientName, double pendingAmount) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.pendingAmount = pendingAmount;
    }
}
