package com.bitnap.jobapp.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitnap.jobapp.review.Review;
import com.bitnap.jobapp.review.ReviewRepository;
import com.bitnap.jobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public void addReview(Long companyId, Review review) {
        
    }

}
