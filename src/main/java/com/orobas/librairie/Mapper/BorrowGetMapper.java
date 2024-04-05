package com.orobas.librairie.Mapper;

import com.orobas.librairie.DTO.BorrowGetDTO;
import com.orobas.librairie.Entity.Borrow;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BorrowGetMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BorrowGetDTO mapToDto(Borrow borrow){
        BorrowGetDTO borrowDTO = modelMapper.map(borrow, BorrowGetDTO.class);

        return borrowDTO;
    }
}
