package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.EarningsDto;
import com.example.Astrology.service.impl.DashboardServiceImpl;
import com.example.Astrology.util.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/dashboard/")
public class DashboardController {

    @Autowired
    private DashboardServiceImpl dashboardService;

    @GetMapping("/upcoming")
    public ResponseEntity<ApiResponse<Page<ConsultationDto>>> getUpcomingConsultations(@RequestParam int size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<ConsultationDto> consultations = dashboardService.getUpcomingConsultations(pageable);
        return ResponseUtil.success(consultations, "Upcoming consultations retrieved successfully!!");
    }

    @GetMapping("/getFinancialReport")
    public ResponseEntity<ApiResponse<EarningsDto>> getFinancialReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        EarningsDto financialReportDto = dashboardService.getFinancialReport(date);
        return ResponseUtil.success(financialReportDto, "Financial Report retrieved successfully!");
    }
}


