package com.example.NMproject.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.NMproject.dto.RatingDTO;
import com.example.NMproject.dto.RatingResponseDTO;
import com.example.NMproject.entity.Book;
import com.example.NMproject.entity.Rating;
import com.example.NMproject.entity.RatingId;
import com.example.NMproject.repository.BookRepository;
import com.example.NMproject.repository.RatingRepository;

@Service
public class RatingService {

	private final RatingRepository ratingRepository;
	private final BookRepository bookRepository;

	public RatingService(RatingRepository ratingRepository, BookRepository bookRepository) {
		this.ratingRepository = ratingRepository;
		this.bookRepository = bookRepository;
	}

	public RatingResponseDTO saveOrUpdateRating(RatingDTO ratingDTO) {
		RatingId ratingId = new RatingId(ratingDTO.getUserID(), ratingDTO.getBookID());
		Rating rating = ratingRepository.findById(ratingId).orElse(null);

		if (rating != null) {
			// Cập nhật ratingscore nếu đã tồn tại
			rating.setRatingScore(ratingDTO.getRate());
		} else {
			// Thêm bản ghi mới nếu chưa tồn tại
			rating = new Rating(ratingDTO.getUserID(), ratingDTO.getBookID(), ratingDTO.getRate());
		}
		ratingRepository.save(rating);

		// Tính lại điểm trung bình sau khi cập nhật
		double bookRating = updateBookRating(ratingDTO.getBookID());

		// Trả về DTO mới
		return new RatingResponseDTO(bookRating, ratingDTO.getRate(), "Đánh giá cuốn sách này thành công!");
	}

	public double updateBookRating(Long bookId) {
		List<Rating> ratings = ratingRepository.findByBookId(bookId);

		double averageRating = ratings.isEmpty() ? 0.0
				: ratings.stream().mapToInt(Rating::getRatingScore).average().orElse(0.0);

		// Làm tròn averageRating đến 1 chữ số sau dấu phẩy
		BigDecimal roundedRating = new BigDecimal(averageRating).setScale(1, RoundingMode.HALF_UP);

		// Cập nhật lại bookRating trong bảng Book
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

		book.setRate(roundedRating.doubleValue()); // Chuyển đổi về double
		bookRepository.save(book);

		return roundedRating.doubleValue();
	}

	public double getBookRating(Long bookId) {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
		return book.getRate();
	}

	public List<Rating> getRatingsByUserID(Long userID) {
		return ratingRepository.findByBookId(userID);
	}
}
