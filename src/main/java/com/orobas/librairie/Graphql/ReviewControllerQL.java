package com.orobas.librairie.Graphql;

import com.orobas.librairie.Entity.Review;
import com.orobas.librairie.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.InstanceNotFoundException;

@Controller
public class ReviewControllerQL {
    @Autowired
    private ReviewService reviewService;

    @QueryMapping
    public Iterable<Review> reviews() {
        return this.reviewService.findAll();
    }

    @QueryMapping
    public Iterable<Review> reviewsByBook() {
        return this.reviewService.findAll();
    }

    @QueryMapping
    public Iterable<Review> reviewsByUser() {
        return this.reviewService.findAll();
    }


    @QueryMapping
    public Review reviewById(Integer id) throws InstanceNotFoundException {
        return this.reviewService.findReviewById(id);
    }
}
