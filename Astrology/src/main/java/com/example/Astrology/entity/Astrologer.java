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

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "bio",columnDefinition = "LONGTEXT")
    private String bio;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;
}
