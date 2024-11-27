package com.example.Astrology.service.impl;

import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.entity.Client;
import com.example.Astrology.exception.ClientExistsException;
import com.example.Astrology.mapper.ClientMapper;
import com.example.Astrology.repository.ClientRepository;
import com.example.Astrology.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto, MultipartFile uploadMedia) throws IOException {

        Client client = new Client();
        client.setDob(clientDto.getDob());
        client.setName(clientDto.getName());
        client.setAge(clientDto.getAge());
        client.setContact(clientDto.getContact());
        client.setAddress(clientDto.getAddress());
        client.setUploadMedia(uploadMedia.getBytes());
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDto(savedClient);
    }

        @Override
        public List<ClientDto> getAllClient (ClientDto clientDto){

        return List.of();
        }

        @Override
        public ClientDto getClientById (Long id){
            return null;
        }

        @Override
        public ClientDto updateClient (ClientDto clientDto){
            return null;
        }

        @Override
        public void deleteClient (Long id){

        }
    }
