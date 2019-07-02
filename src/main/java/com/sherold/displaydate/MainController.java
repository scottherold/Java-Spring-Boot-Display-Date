package com.sherold.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Sets up class as a controller that can return views
@Controller

// Catch-all for root route
@RequestMapping("/")
public class MainController {
	// Root route
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// GET route for date
	@RequestMapping("/date")
	
	// Model allows data injection into JSP rendered
	public String date(Model model) {		
		// Create formatting
		String pattern = "EEEEE', the' d ' of 'MMMMM',' yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		// Sends formatted date to JSP page
		model.addAttribute("date", simpleDateFormat.format(new Date()));
		return "date.jsp";
	}
	
	// GET route for time
	@RequestMapping("/time")
	
	// Model allows data injection into the JSP rendered
	public String time(Model model) {
		// Create formatting
		String pattern = "h:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		// Sends formatted date to JSP page
		model.addAttribute("time", simpleDateFormat.format(new Date()));
		return "time.jsp";
	}
}
