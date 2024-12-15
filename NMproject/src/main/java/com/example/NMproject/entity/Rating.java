package com.example.NMproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(RatingId.class)
public class Rating {
	@Id
	@Column(name = "userid", nullable = false)
	private Long userId;

	@Id
	@Column(name = "bookid", nullable = false)
	private Long bookId;

	@Column(name = "rating_score", nullable = false)
	private Integer ratingScore;

	// Constructors
	public Rating() {
	}

	public Rating(Long userId, Long bookId, Integer ratingScore) {
		this.userId = userId;
		this.bookId = bookId;
		this.ratingScore = ratingScore;
	}

	// Getters and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(Integer ratingScore) {
		this.ratingScore = ratingScore;
	}
}
