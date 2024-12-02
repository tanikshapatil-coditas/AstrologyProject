package com.example.Astrology.service;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {
    ConsultationCreateDto createConsultation(Long clientId, ConsultationDto consultationDto);

    List<ConsultationDto> getClientConsultations(Long clientId);

    ConsultationCreateDto updateConsultation(Long id, ConsultationDto consultationDto);

    void deleteConsultation(Long id);

}

