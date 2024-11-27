package com.example.Astrology.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "astrologers")
public class Astrologer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

}
