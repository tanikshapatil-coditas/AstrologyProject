package com.example.Astrology.service.impl;

import com.example.Astrology.dto.ClientDto;
import com.example.Astrology.dto.ClientNameDto;
import com.example.Astrology.dto.EarningsDto;
import com.example.Astrology.dto.PendingAmountDto;
import com.example.Astrology.entity.Client;
import com.example.Astrology.entity.Consultation;
import com.example.Astrology.exception.InvalidUserIdException;
import com.example.Astrology.mapper.ClientMapper;
import com.example.Astrology.repository.ClientRepository;
import com.example.Astrology.repository.ConsultationRepository;
import com.example.Astrology.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

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
    public List<ClientNameDto> getAllClient(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 5);
        Page<ClientNameDto> clientPage = clientRepository.findAllClientNames(pageRequest);
        return clientPage.getContent();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(InvalidUserIdException::new);
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).orElseThrow(InvalidUserIdException::new);
        client.setName(clientDto.getName());
        client.setAge(clientDto.getAge());
        client.setDob(clientDto.getDob());
        client.setAddress(clientDto.getAddress());
        client.setContact(clientDto.getContact());
        if (clientDto.getUploadMedia() != null) {
            client.setUploadMedia(clientDto.getUploadMedia());
        }
        Client updatedClient = clientRepository.save(client);
        return ClientMapper.toDto(updatedClient);
    }


    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(InvalidUserIdException::new);
//        RefreshToken refreshToken = refreshrepo.findByUserId(id).orElseThrow(RefreshTokenNotFoundException::new);
//        refreshrepo.delete(refreshToken);
        clientRepository.deleteById(id);
    }

    @Override
    public Page<ClientDto> getClients(String sortBy, Pageable pageable) {
        if ("name".equalsIgnoreCase(sortBy)) {
            Pageable sortedByName = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
            return clientRepository.findAll(sortedByName).map(ClientMapper::toDto);
        } else {
            return clientRepository.findAll(pageable).map(ClientMapper::toDto);
        }
    }

    @Override
    public EarningsDto getTotalAndPendingEarnings(Instant startDate, Instant endDate) {
        List<Consultation> consultations = consultationRepository.findByConsultationDateBetween(startDate, endDate);
        double totalEarnings = consultations.stream().mapToDouble(Consultation::getFee).sum();
        double totalPending = consultations.stream().mapToDouble(Consultation::getBalance).sum();
        return new EarningsDto(totalEarnings, totalPending);
    }

    @Override
    public List<PendingAmountDto> getClientsWithPendingAmounts(Instant startDate, Instant endDate) {
        List<Consultation> consultations = consultationRepository.findByConsultationDateBetween(startDate, endDate);
        return consultations.stream().filter(consultation -> consultation.getBalance() > 0).map(consultation -> new PendingAmountDto(consultation.getClient().getId(), consultation.getClient().getName(), consultation.getBalance())).collect(Collectors.toList());
    }
}

