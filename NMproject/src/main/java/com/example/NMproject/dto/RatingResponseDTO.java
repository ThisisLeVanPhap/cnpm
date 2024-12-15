package com.example.NMproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingResponseDTO {
	private double rateAverage;
	private int rate;
	private String message;

	// Constructor
	public RatingResponseDTO(double rateAverage, int rate, String message) {
		this.rateAverage = rateAverage;
		this.rate = rate;
		this.message = message;
	}

}
