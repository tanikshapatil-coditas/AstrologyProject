package com.example.Astrology.mapper;

import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.entity.Consultation;
import com.example.Astrology.entity.Client;

public class ConsultationMapper {

    public static ConsultationDto MaptoDto(Consultation consultation) {
        if (consultation == null) {
            return null;
        }
        return new ConsultationDto(
                consultation.getId(),
                consultation.getConsultationDate(),
                consultation.getCharges(),
                consultation.getBalance(),
                consultation.getNotes(),
                consultation.getClient() != null ? consultation.getClient().getId() : null
        );
    }

    public static Consultation MaptoEntity(ConsultationDto consultationDTO, Client client) {
        if (consultationDTO == null) {
            return null;
        }
        Consultation consultation = new Consultation(
                consultationDTO.getId(),
                consultationDTO.getConsultationDate(),
                consultationDTO.getCharges(),
                consultationDTO.getBalance(),
                consultationDTO.getNotes(),
                client
        );
        consultation.setClient(client);
        return consultation;
    }
}
