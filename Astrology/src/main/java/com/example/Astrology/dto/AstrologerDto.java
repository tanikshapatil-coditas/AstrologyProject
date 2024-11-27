package com.example.Astrology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AstrologerDto {
    private Long id;
    private String username;
    private String password;
}
