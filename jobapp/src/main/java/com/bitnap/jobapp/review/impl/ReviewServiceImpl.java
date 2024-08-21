package com.bitnap.jobapp.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitnap.jobapp.company.Company;
import com.bitnap.jobapp.company.CompanyService;
import com.bitnap.jobapp.review.Review;
import com.bitnap.jobapp.review.ReviewRepository;
import com.bitnap.jobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long ReviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(ReviewId)).findFirst().orElse(null);
    }

}
