package com.orobas.librairie.Service;

import com.orobas.librairie.DTO.BorrowGetDTO;
import com.orobas.librairie.DTO.BorrowPostDTO;
import com.orobas.librairie.DTO.BorrowPutDTO;
import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Entity.Borrow;
import com.orobas.librairie.Mapper.BorrowGetMapper;
import com.orobas.librairie.Mapper.BorrowPostMapper;
import com.orobas.librairie.Repository.BorrowRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowService {
    private BorrowRepository borrowRepository;

    public List<BorrowGetDTO> getAll() {
        return this.borrowRepository.findAll().stream().map(BorrowGetMapper::mapToDto).collect(Collectors.toList());
    }
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

    public BorrowGetDTO update(Integer id, BorrowPutDTO borrowPutDTO) throws Exception {
        Borrow borrow = this.borrowRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);

        if (borrow.getReturnAt() != null) {
            throw new Exception("Cet emprunt à déjà été rendu");
        }

        borrow.setReturnAt(validateReturnDate(borrow, borrowPutDTO.getReturnAt()));
        borrow.setEndCondition(validateCondition(borrowPutDTO.getEndCondition()));

        borrow.setCost(borrow.calculateCost());

        this.borrowRepository.save(borrow);

        return BorrowGetMapper.mapToDto(borrow);
    }

    public LocalDate validateReturnDate(Borrow borrow, LocalDate date) throws Exception {
        LocalDate startAt = borrow.getStartAt();
        if (!startAt.isBefore(date)) {
            throw new Exception("La date de retour doit être supérieure à la date d'emprunt ("+ startAt +")");
        }
        return date;
    }

    public String validateCondition(String condition) throws Exception {
        if (!Book.conditions.containsKey(condition)) {
            throw new Exception("La valeur de 'condition' doit être une des valeurs suivantes : "+ Book.conditions.toString());
        }

        return condition;
    }
}
