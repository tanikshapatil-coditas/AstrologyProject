package com.example.Astrology.service;

import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.EarningsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface DashboardService {
    Page<ConsultationDto> getUpcomingConsultations(Pageable pageable);
    EarningsDto getFinancialReport(LocalDate date);


}
