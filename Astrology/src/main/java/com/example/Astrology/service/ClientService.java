package com.example.Astrology.service;

import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ClientNameDto;
import com.example.Astrology.dto.EarningsDto;
import com.example.Astrology.dto.PendingAmountDto;
import com.example.Astrology.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto, MultipartFile uploadMedia) throws IOException;

    List<ClientNameDto> getAllClient(int pageNumber);

    Client getClientById(Long id);

    public ClientDto updateClient(Long id, ClientDto clientDto);

    void deleteClient(Long id);

    Page<ClientDto> getClients(String sortBy, Pageable pageable);

    EarningsDto getTotalAndPendingEarnings(LocalDate startDate, LocalDate endDate);

    List<PendingAmountDto> getClientsWithPendingAmounts(LocalDate startDate, LocalDate endDate);
}