package com.example.Astrology.repository;

import com.example.Astrology.entity.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    List<Consultation> findByClientId(Long clientId);

    @Query(value = "SELECT * FROM consultations ORDER BY next_consultation_date ASC;",nativeQuery = true)
    Page<Consultation> findByConsultationDateAfterOrderByConsultationDateAsc(Date date, Pageable pageable);

    @Query(value = "SELECT * FROM consultations WHERE EXTRACT(MONTH FROM consultation_date) = :month AND EXTRACT(YEAR FROM consultation_date) = :year", nativeQuery = true)
    List<Consultation> findMonthlyEarnings(@Param("month") int month, @Param("year") int year);
}
