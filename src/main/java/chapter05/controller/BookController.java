package chapter05.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import chapter05.domain.Book;
import chapter05.domain.Category;
import chapter05.service.BookService;

@Controller
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/input-book")
	public String inputBook(Model model) {
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		return "bookAddForm";
	}
	
	@RequestMapping(value = "/edit-book/{id}")
	public String editBook(Model model, @PathVariable long id) {
		List<Category> categories = bookService.getAllCategories();
		Book book = bookService.get(id);
		model.addAttribute("categories", categories);
		model.addAttribute("book", book);
		return "bookEditForm";
	}
	
	@RequestMapping(value = "/save-book")
	public String saveBook(@ModelAttribute Book book) {
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/list-book";
	}
	
	@RequestMapping(value = "/update-book")
	public String updateBook(@ModelAttribute Book book) {
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/list-book";
	}
	
	@RequestMapping(value = "/list-book")
	public String listBooks(Model model) {
		logger.info("listBooks");
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "bookList";
	}
}
