package com.kcFinder.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String loadAdminMain() {
		return "thymeleaf/admin/main.html";
	}
}
