package com.example.Astrology.mapper;

import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.entity.Client;

public class ClientMapper {

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setDob(clientDto.getDob());
        client.setAddress(clientDto.getAddress());
        client.setAge(clientDto.getAge());
        client.setContact(clientDto.getContact());


        return client;
    }

    public static ClientDto toDto(Client client) {
        if (client == null) {
            return null;
        }
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setDob(client.getDob());
        clientDto.setAddress(client.getAddress());
        clientDto.setAge(client.getAge());
        clientDto.setUploadMedia(client.getUploadMedia());
        clientDto.setContact(client.getContact());


        return clientDto;
    }
}
