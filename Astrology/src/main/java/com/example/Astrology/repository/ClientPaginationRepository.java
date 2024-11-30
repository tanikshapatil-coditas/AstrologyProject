package com.example.Astrology.repository;

import com.example.Astrology.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPaginationRepository extends PagingAndSortingRepository<Client, Long>{
    @Query("SELECT c FROM Client c ORDER BY c.name ASC")
    Page<Client> findAllSortedByName(Pageable pageable);

    @Query("SELECT c FROM Client c WHERE c.name = :name")
    Page<Client> findByName(String name, Pageable pageable);

    Iterable<Client> findAll(Sort sort);
}