package com.orobas.librairie.Mapper;

import com.orobas.librairie.DTO.BorrowPutDTO;
import com.orobas.librairie.Entity.Borrow;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BorrowPutMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BorrowPutDTO mapToDto(Borrow borrow){
        BorrowPutDTO borrowDTO = modelMapper.map(borrow, BorrowPutDTO.class);

        return borrowDTO;
    }

    public static Borrow mapToEntity(BorrowPutDTO borrowPostDTO) {
        Borrow borrow = modelMapper.map(borrowPostDTO, Borrow.class);

        return borrow;
    }
}
