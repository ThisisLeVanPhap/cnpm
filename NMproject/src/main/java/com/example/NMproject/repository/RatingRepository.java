package com.example.NMproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NMproject.entity.Rating;
import com.example.NMproject.entity.RatingId;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
	boolean existsByUserIdAndBookId(Long userId, Long bookId);

	Rating findByUserIdAndBookId(Long userId, Long bookId);

	List<Rating> findByBookId(Long bookId);
}