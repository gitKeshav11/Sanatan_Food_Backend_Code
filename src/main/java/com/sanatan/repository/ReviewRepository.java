package com.sanatan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanatan.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
