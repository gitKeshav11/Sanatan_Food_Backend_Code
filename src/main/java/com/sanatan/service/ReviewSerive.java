package com.sanatan.service;

import java.util.List;

import com.sanatan.Exception.ReviewException;
import com.sanatan.model.Review;
import com.sanatan.model.User;
import com.sanatan.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
