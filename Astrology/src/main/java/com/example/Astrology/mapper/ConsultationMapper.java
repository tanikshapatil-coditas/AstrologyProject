package com.example.Astrology.mapper;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.ConsultationWithClientDto;
import com.example.Astrology.dto.GetAllConsultationsDto;
import com.example.Astrology.entity.Consultation;

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
        consultationDto.setClientId(consultation.getClient().getId());
        consultationDto.setName(consultation.getClient().getName());
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

    public static GetAllConsultationsDto getAllConsultationsDto(Consultation consultation){
        GetAllConsultationsDto getAllConsultationsDto = new GetAllConsultationsDto();
        getAllConsultationsDto.setId(consultation.getId());
        getAllConsultationsDto.setConsultationDate(consultation.getConsultationDate());
        getAllConsultationsDto.setFee(consultation.getFee());
        getAllConsultationsDto.setAmountPaid(consultation.getAmountPaid());
        getAllConsultationsDto.setBalance(consultation.getBalance());
        getAllConsultationsDto.setNotes(consultation.getNotes());
        getAllConsultationsDto.setNextConsultationDate(consultation.getNextConsultationDate());
        return getAllConsultationsDto;
    }

    public static ConsultationWithClientDto consultationWithClientDto(Consultation consultation) {
        ConsultationWithClientDto consultationWithClientDto = new ConsultationWithClientDto();
        consultationWithClientDto.setId(consultation.getId());
        consultationWithClientDto.setName(consultation.getClient().getName());
        consultationWithClientDto.setDob(consultation.getClient().getDob());
        consultationWithClientDto.setAddress(consultation.getClient().getAddress());
        consultationWithClientDto.setAge(consultation.getClient().getAge());
        consultationWithClientDto.setContact(consultation.getClient().getContact());
        consultationWithClientDto.setConsultationDate(consultation.getConsultationDate());
        consultationWithClientDto.setFee(consultation.getFee());
        consultationWithClientDto.setAmountPaid(consultation.getAmountPaid());
        consultationWithClientDto.setBalance(consultation.getBalance());
        consultationWithClientDto.setNotes(consultation.getNotes());
        consultationWithClientDto.setNextConsultationDate(consultation.getNextConsultationDate());
        consultationWithClientDto.setClientId(consultation.getClient().getId());
        return consultationWithClientDto;
    }
}
