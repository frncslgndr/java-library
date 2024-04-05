package com.orobas.librairie.Service;

import com.orobas.librairie.DTO.ReviewDto;
import com.orobas.librairie.Entity.Review;
import com.orobas.librairie.Mapper.ReviewMapper;
import com.orobas.librairie.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //Fonction pour récupérer toutes les avis
    public List<ReviewDto> findAllReviews() {
        return this.reviewRepository.findAll().stream().map(review -> ReviewMapper.mapToDto(review)).collect(Collectors.toList());
    }

    //Fonctions pour récupérer 1 avis via son ID
    public Review findReviewById(Integer id) throws InstanceNotFoundException {
        return this.reviewRepository.findById(id).orElseThrow(InstanceNotFoundException::new);
    }

    //Fonction pour récupérer tous les avis d'un livre
    public List<ReviewDto> findAllReviewsFromABookTitle(String title) {
        return this.reviewRepository.findAllByBook_Title(title).stream().map(review -> ReviewMapper.mapToDto(review)).collect(Collectors.toList());
    }


    //Fonction pour ajouter un avis
    public Review Review(Review review)  {
        return this.reviewRepository.save(review);
    }

    //Fonction pour supprimer un avis
    public void delete(Integer id) throws InstanceNotFoundException{
        this.reviewRepository.deleteById(id);
    }
}
