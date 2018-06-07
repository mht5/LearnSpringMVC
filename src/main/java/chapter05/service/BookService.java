package chapter05.service;

import java.util.List;

import chapter05.domain.Book;
import chapter05.domain.Category;

public interface BookService {
	List<Category> getAllCategories();
	Category getCategory(int id);
	List<Book> getAllBooks();
	Book get(long id);
	Book save(Book book);
	Book update(Book book);
	long getNextId();
}
