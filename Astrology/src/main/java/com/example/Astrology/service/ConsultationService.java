package com.example.Astrology.service;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {
    public ConsultationCreateDto createConsultation(Long clientId, ConsultationDto consultationDto);
    public List<ConsultationDto> getClientConsultations(Long clientId);
    public ConsultationCreateDto updateConsultation(Long id, ConsultationDto consultationDto);
    public void deleteConsultation(Long id);


}
