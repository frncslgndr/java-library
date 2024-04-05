package com.orobas.librairie.Mapper;

import com.orobas.librairie.DTO.BorrowPostDTO;
import com.orobas.librairie.Entity.Borrow;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BorrowPostMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BorrowPostDTO mapToDto(Borrow borrow){
        BorrowPostDTO borrowDTO = modelMapper.map(borrow, BorrowPostDTO.class);

        return borrowDTO;
    }

    public static Borrow mapToEntity(BorrowPostDTO borrowPostDTO) {
        Borrow borrow = modelMapper.map(borrowPostDTO, Borrow.class);

        return borrow;
    }
}
