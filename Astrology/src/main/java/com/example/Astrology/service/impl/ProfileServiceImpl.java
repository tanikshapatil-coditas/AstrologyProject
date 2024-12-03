package com.example.Astrology.service.impl;

import com.example.Astrology.dto.ProfileDto;
import com.example.Astrology.entity.Astrologer;
import com.example.Astrology.exception.UsernameRequiredException;
import com.example.Astrology.repository.AstrologyRepository;
import com.example.Astrology.repository.ClientRepository;
import com.example.Astrology.service.ProfileService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
@NoArgsConstructor
@Data
public class ProfileServiceImpl implements ProfileService {

    private Astrologer astrologer;

    @Autowired
    private AstrologyRepository astrologyRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ProfileServiceImpl(Astrologer astrologer, AstrologyRepository astrologyRepository) {
        this.astrologer = astrologer;
        this.astrologyRepository = astrologyRepository;
    }

    @Override
    public ProfileDto viewProfile(String username) {
        Astrologer astrologer = astrologyRepository.findByUsername(username).orElseThrow(UsernameRequiredException::new);
        ProfileDto profileDto = new ProfileDto();
        profileDto.setUsername(astrologer.getUsername());
        profileDto.setFullName(astrologer.getFullname());
        profileDto.setEmailId(astrologer.getEmailId());
        profileDto.setPhoneNumber(astrologer.getPhoneNumber());
        profileDto.setBio(astrologer.getBio());
        profileDto.setYearsOfExperience(astrologer.getYearsOfExperience());
        Long totalClientList = clientRepository.findAll().stream().count();
        profileDto.setTotalNoOfClients(totalClientList);
        return profileDto;
    }
}
