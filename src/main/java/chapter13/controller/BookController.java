package chapter13.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import chapter13.domain.Book;

@Controller
public class BookController {

	@RequestMapping(value = "/latest/{pubYear}")
	public ModelAndView getLatestTitle(@PathVariable String pubYear) {
		ModelAndView mav = new ModelAndView("latestTitle");
		if ("2016".equals(pubYear)) {
			List<Book> bookList = Arrays.asList(
					new Book("0001", "book1", "Jon", LocalDate.of(2016, 6, 1)),
					new Book("0002", "book2", "John", LocalDate.of(2016, 12, 12)),
					new Book("0003", "book3", "Joan", LocalDate.of(2016, 8, 20))
			);
			mav.getModel().put("latest", bookList);
		}
		return mav;
	}
}
