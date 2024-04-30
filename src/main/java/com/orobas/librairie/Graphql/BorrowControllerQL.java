package com.orobas.librairie.Graphql;

import com.orobas.librairie.Entity.Borrow;
import com.orobas.librairie.Repository.BorrowRepository;
import com.orobas.librairie.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BorrowControllerQL {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BorrowRepository borrowRepository;

    @QueryMapping
    public Iterable<Borrow> borrows() {
        return this.borrowService.findAll();
    }

    @QueryMapping
    public List<Borrow> borrowsByUser(Integer user_id) throws InstanceNotFoundException {
        return this.borrowRepository.findAllByUserId(user_id);
    }

    @QueryMapping
    public List<Borrow> borrowsByBook(Integer book_id) throws InstanceNotFoundException {
        return this.borrowRepository.findAllByBookId(book_id);
    }
}
