package com.example.Astrology.mapper;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.entity.Consultation;
import com.example.Astrology.entity.Client;

public class ConsultationMapper {

    public static Consultation toEntity(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();

        consultation.setConsultationDate(consultationDto.getConsultationDate());
        consultation.setFee(consultationDto.getFee());
        consultation.setAmountPaid(consultationDto.getAmountPaid());
        consultation.setBalance(consultationDto.getBalance());
        consultation.setNotes(consultationDto.getNotes());
        consultation.setNextConsultationDate(consultationDto.getNextConsultationDate());
        return consultation;
    }

    public static ConsultationDto toConsultationDto(Consultation consultation) {
        ConsultationDto consultationDto = new ConsultationDto();
        consultationDto.setId(consultation.getId());
        consultationDto.setConsultationDate(consultation.getConsultationDate());
        consultationDto.setFee(consultation.getFee());
        consultationDto.setAmountPaid(consultation.getAmountPaid());
        consultationDto.setBalance(consultation.getBalance());
        consultationDto.setNotes(consultation.getNotes());
        consultationDto.setNextConsultationDate(consultation.getNextConsultationDate());
        return consultationDto;
    }

    public static ConsultationCreateDto consultationCreateDto(Consultation consultation) {
        ConsultationCreateDto consultationCreateDto = new ConsultationCreateDto();
        consultationCreateDto.setId(consultation.getId());
        consultationCreateDto.setConsultationDate(consultation.getConsultationDate());
        consultationCreateDto.setFee(consultation.getFee());
        consultationCreateDto.setAmountPaid(consultation.getAmountPaid());
        consultationCreateDto.setBalance(consultation.getBalance());
        consultationCreateDto.setNotes(consultation.getNotes());
        consultationCreateDto.setNextConsultationDate(consultation.getNextConsultationDate());
        return consultationCreateDto;

    }


}
