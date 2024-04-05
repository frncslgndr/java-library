package com.orobas.librairie.Controller;

import com.orobas.librairie.DTO.BorrowGetDTO;
import com.orobas.librairie.DTO.BorrowPostDTO;
import com.orobas.librairie.DTO.BorrowPutDTO;
import com.orobas.librairie.Entity.Borrow;
import com.orobas.librairie.Service.BorrowService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/borrow")
public class BorrowController {

    private BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/book/{book_id}")
    public List<BorrowGetDTO> getBorrowByBook(@PathVariable("book_id") Integer book_id) {
        return this.borrowService.findAllByBook(book_id);
    }

    @GetMapping("/user/{user_id}")
    public List<BorrowGetDTO> getBorrowByUser(@PathVariable("user_id") Integer user_id) {
        return this.borrowService.findAllByUser(user_id);
    }

    @PostMapping("/new")
    public void addNewBorrow(@RequestBody BorrowPostDTO borrowPostDTO) {
        this.borrowService.create(borrowPostDTO);
    }

    @PatchMapping("/return/{id}")
    public void endBorrow(@PathVariable("id") Integer id, @RequestBody BorrowPutDTO borrowPutDTO) throws ChangeSetPersister.NotFoundException {
        this.borrowService.update(id, borrowPutDTO);
    }

}
