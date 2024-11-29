package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.EarningsDto;
import com.example.Astrology.dto.PendingAmountDto;
import com.example.Astrology.dto.ResponseUtil;
import com.example.Astrology.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/earnings")
@AllArgsConstructor
public class EarningsController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/totalAndPending")
    public ResponseEntity<ApiResponse<EarningsDto>> getTotalAndPendingEarnings(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant endDate) {
        EarningsDto earnings = clientService.getTotalAndPendingEarnings(startDate, endDate);
        return ResponseUtil.success(earnings, "Earnings retrieved successfully!!");
    }

    @GetMapping("/pendingClients")
    public ResponseEntity<ApiResponse<List<PendingAmountDto>>> getClientsWithPendingAmounts(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant endDate) {
        List<PendingAmountDto> pendingClients = clientService.getClientsWithPendingAmounts(startDate, endDate);
        return ResponseUtil.success(pendingClients, "Pending clients retrieved successfully!!");
    }
}
