package com.orobas.librairie.Service;

import com.orobas.librairie.DTO.BorrowGetDTO;
import com.orobas.librairie.DTO.BorrowPostDTO;
import com.orobas.librairie.DTO.BorrowPutDTO;
import com.orobas.librairie.Entity.Borrow;
import com.orobas.librairie.Mapper.BorrowGetMapper;
import com.orobas.librairie.Mapper.BorrowPostMapper;
import com.orobas.librairie.Mapper.ReviewMapper;
import com.orobas.librairie.Repository.BorrowRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowService {
    private BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<BorrowGetDTO> findAllByBook(Integer book_id) {
        return this.borrowRepository.findAllByBookId(book_id).stream().map(BorrowGetMapper::mapToDto).collect(Collectors.toList());
    }
    public List<BorrowGetDTO> findAllByUser(Integer user_id) {
        return this.borrowRepository.findAllByUserId(user_id).stream().map(BorrowGetMapper::mapToDto).collect(Collectors.toList());
    }

    public void create(BorrowPostDTO borrowPostDTO) {
        this.borrowRepository.save(BorrowPostMapper.mapToEntity(borrowPostDTO));
    }

    public void update(Integer id, BorrowPutDTO borrowPutDTO) throws ChangeSetPersister.NotFoundException {
        Borrow borrow = this.borrowRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);

        borrow.setReturnAt(borrowPutDTO.getReturnAt());
        borrow.setEndCondition(borrowPutDTO.getEndCondition());

        this.borrowRepository.save(borrow);
    }
}
