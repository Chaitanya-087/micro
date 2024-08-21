package com.bitnap.jobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId, Long ReviewId);
}
