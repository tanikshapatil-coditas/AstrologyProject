package com.example.Astrology.service;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.ConsultationWithClientDto;
import com.example.Astrology.entity.Client;

import java.util.List;

public interface ConsultationService {
    ConsultationCreateDto createConsultation(Long clientId, ConsultationDto consultationDto);

    List<ConsultationWithClientDto> getClientConsultations(Long clientId);

    ConsultationCreateDto updateConsultation(Long id, ConsultationDto consultationDto);

    void deleteConsultation(Long id);

    Client getClient(Long id);
}

