package com.bitnap.jobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(Long companyId);
    void addReview(Long companyId,Review review);
}
