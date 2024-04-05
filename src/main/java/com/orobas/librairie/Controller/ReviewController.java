package com.orobas.librairie.Controller;


import com.orobas.librairie.DTO.ReviewDto;
import com.orobas.librairie.Entity.Review;
import com.orobas.librairie.Service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //READ
    //Récupérer tous les livres
    @GetMapping("/read/all")
    public List<ReviewDto> findAllReviews() {
        return reviewService.findAllReviews();
    }

    //Récupéer tous les avis d'un livre
    @GetMapping("/read/{title}")
    public List<ReviewDto> findAllReviewsFromABook(@PathVariable("title") String title) {
        return reviewService.findAllReviewsFromABookTitle(title);
    }
}
