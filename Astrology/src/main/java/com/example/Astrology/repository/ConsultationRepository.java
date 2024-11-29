package com.example.Astrology.repository;

import com.example.Astrology.entity.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByClientId(Long clientId);

    Page<Consultation> findByConsultationDateAsc(Date date, Pageable pageable);

    List<Consultation> findByConsultationDateBetween(LocalDate startDate, LocalDate endDate);
}
