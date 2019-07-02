package com.sherold.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// GET route for date/time
	@RequestMapping("/{dateTime}")
	
	// Model allows data injection into JSP rendered
	public String date(@PathVariable("dateTime") String dateTime, Model model) {		
		// Event handler for URL
		if (dateTime.equals("date")) {
			// Create formatting
			String pattern = "EEEEE', the' d ' of 'MMMMM',' yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			// Sends formatted date to JSP page
			model.addAttribute("date", simpleDateFormat.format(new Date()));
			return "date.jsp";
		} else if (dateTime.equals("time")) {
			// Create formatting
			String pattern = "h:mm a";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			// Sends formatted date to JSP page
			model.addAttribute("time", simpleDateFormat.format(new Date()));
			return "time.jsp";
		} else {
			return "index.jsp";
		}
		
	}
}
