package com.example.Astrology.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity{

    @Column(name = "token",columnDefinition = "TEXT")
    private String token;

    @Column(name = "expiryDate", nullable = false)
    private Instant expiryDate;

    @OneToOne
    @JoinColumn(name = "astrologer_id", referencedColumnName = "id")
    private Astrologer user;
}
