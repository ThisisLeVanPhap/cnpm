package com.example.NMproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/home")
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return "home"; // Tên tệp HTML trong thư mục templates (home.html)
	}
}
