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

//    public static Astrologer mapToEntity(AstrologerDto astrologerDTO) {
//        if (astrologerDTO == null) {
//            return null;
//        }
//        return new Astrologer(
//                astrologerDTO.getId(),
//                astrologerDTO.getUsername(),
//                astrologerDTO.getPassword()
//        );
//    }
}
