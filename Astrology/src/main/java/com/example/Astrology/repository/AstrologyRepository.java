package com.example.Astrology.repository;

import com.example.Astrology.entity.Astrologer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AstrologyRepository extends JpaRepository<Astrologer,Long> {
    Optional<Astrologer> findByUsername(String username);
}
