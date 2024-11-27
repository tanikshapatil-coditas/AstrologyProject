package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ClientNameDto;
import com.example.Astrology.dto.ResponseUtil;
import com.example.Astrology.repository.ClientRepository;
import com.example.Astrology.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ClientDto>> createClient(@RequestPart("client") String data, @RequestPart("uploadMedia") MultipartFile uploadMedia) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClientDto clientDto = objectMapper.readValue(data, ClientDto.class);
        ClientDto savedClient = clientService.createClient(clientDto, uploadMedia);
        return ResponseUtil.success(savedClient, "Client saved successfully!!");
    }

    @GetMapping("/getAll/{pageNumber}")
    public ResponseEntity<ApiResponse<List<ClientNameDto>>> getAllClients(@PathVariable int pageNumber) {
        List<ClientNameDto> clientNames = clientService.getAllClient(pageNumber);
        return ResponseUtil.success(clientNames, "Clients retrieved successfully!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ClientDto>> updateClient(@PathVariable Long id, @RequestPart("client") String data, @RequestPart("uploadMedia") MultipartFile uploadMedia) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClientDto clientDto = objectMapper.readValue(data, ClientDto.class);
        if (uploadMedia != null && !uploadMedia.isEmpty()) {
            clientDto.setUploadMedia(uploadMedia.getBytes());
        }
        ClientDto updatedClient = clientService.updateClient(id, clientDto);
        return ResponseUtil.success(updatedClient, "Client updated successfully!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseUtil.success(null, "Client deleted successfully!!");
    }
}



