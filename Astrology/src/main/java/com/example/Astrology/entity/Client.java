package com.example.Astrology.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Client name is required")
    private String name;

    @Column(name = "dob", nullable = false)
    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    private Date dob;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Column(name = "age", nullable = false)
    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be equal or greater than 0")
    @Max(value = 150, message = "Age must be less than 150")
    private Integer age;

    @Column(name = "contact", nullable = false)
    @NotBlank(message = "Contact is required")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid contact number")
    private String contact;


    @Column(name = "upload_media")
    private byte[] uploadMedia;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations;

    public Client() {
    }
}
