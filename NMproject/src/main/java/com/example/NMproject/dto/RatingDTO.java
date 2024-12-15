package com.example.NMproject.dto;

public class RatingDTO {
	// @NotNull
	private Long userID;

	/* @NotNull */
	private Long bookID;

	/*
	 * @NotNull
	 * 
	 * @Min(1)
	 * 
	 * @Max(10)
	 */
	private int rate;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}