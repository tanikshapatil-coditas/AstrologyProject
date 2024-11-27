package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ResponseUtil;
import com.example.Astrology.entity.Client;
import com.example.Astrology.service.impl.ClientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ClientDto>> createClient(@RequestPart("client")String data, @RequestPart("uploadMedia")MultipartFile uploadMedia)throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClientDto clientDto = objectMapper.readValue(data, ClientDto.class);
        ClientDto savedClient = clientService.createClient(clientDto,uploadMedia);
        return ResponseUtil.success(savedClient, "Client saved successfully!!");
    }

}
