package com.example.Astrology.controller;

import com.example.Astrology.dto.ApiResponse;
import com.example.Astrology.dto.ConsultationCreateDto;
import com.example.Astrology.dto.ConsultationDto;
import com.example.Astrology.dto.ResponseUtil;
import com.example.Astrology.service.ConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
@AllArgsConstructor
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping("create/{clientId}")
    public ResponseEntity<ApiResponse<ConsultationCreateDto>> createConsultation(@PathVariable Long clientId, @RequestBody ConsultationDto consultationDto) {
        ConsultationCreateDto savedConsultation = consultationService.createConsultation(clientId, consultationDto);
        return ResponseUtil.success(savedConsultation, "Consultation created successfully!!");
    }

    @GetMapping("/getAll/{clientId}")
    public ResponseEntity<ApiResponse<List<ConsultationDto>>> getClientConsultations(@PathVariable Long clientId) {
        List<ConsultationDto> consultations = consultationService.getClientConsultations(clientId);
        return ResponseUtil.success(consultations, "Consultations retrieved successfully!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ConsultationCreateDto>> updateConsultation(@PathVariable Long id, @RequestBody ConsultationDto consultationDto) {
        ConsultationCreateDto updatedConsultation = consultationService.updateConsultation(id, consultationDto);
        return ResponseUtil.success(updatedConsultation, "Consultation updated successfully!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
        return ResponseUtil.delete(null, "Consultation deleted successfully!!");
    }

    @GetMapping("/upcoming")
    public ResponseEntity<ApiResponse<Page<ConsultationDto>>> getUpcomingConsultations(@RequestParam int size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<ConsultationDto> consultations = consultationService.getUpcomingConsultations(pageable);
        return ResponseUtil.success(consultations, "Upcoming consultations retrieved successfully!!");
    }
}
