package com.example.Astrology.repository;

import com.example.Astrology.dto.ClientNameDto;
import com.example.Astrology.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT new com.example.Astrology.dto.ClientNameDto(c.name) FROM Client c")
    Page<ClientNameDto> findAllClientNames(Pageable pageable);
}
