package com.example.NMproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long bookId;

	// Constructors
	public RatingId() {
	}

	public RatingId(Long userId, Long bookId) {
		this.userId = userId;
		this.bookId = bookId;
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

	// equals() and hashCode()
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RatingId ratingId = (RatingId) o;
		return Objects.equals(userId, ratingId.userId) && Objects.equals(bookId, ratingId.bookId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, bookId);
	}
}