package com.orobas.librairie.Mapper;

import com.orobas.librairie.DTO.ReviewDto;
import com.orobas.librairie.Entity.Review;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ReviewDto mapToDto(Review review){
        ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);

        return reviewDto;
    }
}
