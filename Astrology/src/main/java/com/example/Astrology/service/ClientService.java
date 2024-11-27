package com.example.Astrology.service;

import com.example.Astrology.dto.ClientDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto, MultipartFile uploadMedia) throws IOException;

    List<ClientDto> getAllClient(ClientDto clientDto);

    ClientDto getClientById(Long id);

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(Long id);

}
