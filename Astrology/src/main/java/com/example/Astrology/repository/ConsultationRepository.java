package com.example.Astrology.repository;

import com.example.Astrology.entity.Consultation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByClientId(Long clientId);

    Page<Consultation> findByConsultationDateAfterOrderByConsultationDateAsc(Date date, Pageable pageable);

    @Query(value = "SELECT * FROM consultations WHERE createdOn BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Consultation> findByConsultationDateBetween(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
}
