package com.example.Astrology.mapper;

import com.example.Astrology.dto.ClientDetailsDtoWithoutMedia;
import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ClientNameDto;
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

    public static ClientNameDto toClientNameDto(Client client) {
        ClientNameDto clientNameDto = new ClientNameDto();
        clientNameDto.setId(client.getId());
        clientNameDto.setName(client.getName());
        return clientNameDto;
    }

    public static ClientDetailsDtoWithoutMedia toClientDetailsWithoutMedia(Client client) {
        ClientDetailsDtoWithoutMedia clientDetailsDtoWithoutMedia = new ClientDetailsDtoWithoutMedia();
        clientDetailsDtoWithoutMedia.setId(client.getId());
        clientDetailsDtoWithoutMedia.setName(client.getName());
        clientDetailsDtoWithoutMedia.setAge(client.getAge());
        clientDetailsDtoWithoutMedia.setDob(client.getDob());
        clientDetailsDtoWithoutMedia.setContact(client.getContact());
        clientDetailsDtoWithoutMedia.setAddress(client.getAddress());
        return clientDetailsDtoWithoutMedia;
    }
}
