package com.example.Astrology.mapper;

import com.example.Astrology.dto.AstrologerDto;
import com.example.Astrology.entity.Astrologer;

public class AstrologerMapper {

    public static AstrologerDto mapToDto(Astrologer astrologer) {
        if (astrologer == null) {
            return null;
        }
        return new AstrologerDto(
                astrologer.getId(),
                astrologer.getUsername(),
                astrologer.getPassword()
        );
    }

}
