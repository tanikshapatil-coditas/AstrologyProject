package com.example.Astrology.service.impl;

import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.entity.Client;
import com.example.Astrology.entity.Consultation;
import com.example.Astrology.exception.ConsultationNotFoundException;
import com.example.Astrology.exception.InvalidUserIdException;
import com.example.Astrology.mapper.ConsultationMapper;
import com.example.Astrology.repository.ClientRepository;
import com.example.Astrology.repository.ConsultationRepository;
import com.example.Astrology.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public ConsultationCreateDto createConsultation(Long clientId, ConsultationDto consultationDto) {
        Client client = clientRepository.findById(clientId).orElseThrow(InvalidUserIdException::new);
        Consultation consultation = ConsultationMapper.toEntity(consultationDto);
        consultation.setClient(client);
        Consultation savedConsultation = consultationRepository.save(consultation);
        return ConsultationMapper.consultationCreateDto(savedConsultation);
    }

    @Override
    public List<ConsultationDto> getClientConsultations(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(InvalidUserIdException::new);
        List<Consultation> consultations = consultationRepository.findByClientId(clientId);
        return consultations.stream().map(ConsultationMapper::toConsultationDto).collect(Collectors.toList());
    }

    @Override
    public ConsultationCreateDto updateConsultation(Long id, ConsultationDto consultationDto) {
        Consultation consultation = consultationRepository.findById(id).orElseThrow(ConsultationNotFoundException::new);
        consultation.setConsultationDate(consultationDto.getConsultationDate());
        consultation.setFee(consultationDto.getFee());
        consultation.setAmountPaid(consultationDto.getAmountPaid());
        consultation.setBalance(consultationDto.getBalance());
        consultation.setNotes(consultationDto.getNotes());
        consultation.setNextConsultationDate(consultationDto.getNextConsultationDate());
        Consultation updatedConsultation = consultationRepository.save(consultation);
        return ConsultationMapper.consultationCreateDto(updatedConsultation);
    }

    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id).orElseThrow(ConsultationNotFoundException::new);
        consultationRepository.delete(consultation);
    }

    @Override
    public Page<ConsultationDto> getUpcomingConsultations(Pageable pageable) {
        LocalDate today = LocalDate.now();
        Date startDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return consultationRepository.findByConsultationDateAfterOrderByConsultationDateAsc(startDate, pageable).map(ConsultationMapper::toConsultationDto);
    }
}
