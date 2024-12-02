package com.example.Astrology.service.impl;

import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.EarningsDto;
import com.example.Astrology.entity.Consultation;
import com.example.Astrology.mapper.ConsultationMapper;
import com.example.Astrology.repository.ConsultationRepository;
import com.example.Astrology.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private ConsultationRepository consultationRepository;

    public DashboardServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Page<ConsultationDto> getUpcomingConsultations(Pageable pageable) {
        LocalDate today = LocalDate.now();
        Date startDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return consultationRepository.findByConsultationDateAfterOrderByConsultationDateAsc(startDate, pageable).map(ConsultationMapper::toConsultationDto);
    }

    @Override
    public EarningsDto getFinancialReport(LocalDate date) {
        Month month = date.getMonth();
        int m = month.getValue();
        int year = date.getYear();
        List<Consultation> monthlyConsultations = consultationRepository.findMonthlyEarnings(m, year);
        Double monthlyEarning = monthlyConsultations.stream().mapToDouble(Consultation::getFee).sum();
        Double amountPaid = monthlyConsultations.stream().mapToDouble(Consultation::getAmountPaid).sum();
        Double balance = monthlyConsultations.stream().mapToDouble(Consultation::getBalance).sum();
        return new EarningsDto(monthlyEarning, amountPaid, balance);
    }
}