package com.example.NMproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentid")
	private Long commentID;

	@Column(name = "bookid", nullable = false)
	private Long bookID;

	@Column(name = "userid", nullable = false)
	private int userID;

	@Column(nullable = false, length = 100)
	private String content;

	@Column(nullable = false)
	private LocalDateTime lastUpdate;
}