package com.example.Astrology.service;

import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ClientNameDto;
import com.example.Astrology.entity.Client;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto, MultipartFile uploadMedia) throws IOException;

    List<ClientNameDto> getAllClient(int pageNumber);

    Client getClientById(Long id);

    public ClientDto updateClient(Long id,ClientDto clientDto);

    void deleteClient(Long id);

//    public List<ClientNameDto> viewAllClients(int pageNo,String sort);
}
