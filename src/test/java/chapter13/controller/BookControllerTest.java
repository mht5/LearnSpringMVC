package chapter13.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import chapter13.domain.Book;

/**
 * 使用ModelAndViewAssert进行测试
 * @author mohan
 *
 */
public class BookControllerTest {
	
	@Test
	public void testGetLatestTitle() {
		BookController bookController = new BookController();
		ModelAndView mav = bookController.getLatestTitle("2016");
		
		ModelAndViewAssert.assertViewName(mav, "latestTitle");
		ModelAndViewAssert.assertModelAttributeAvailable(mav, "latest");
		List<Book> bookList = Arrays.asList(
				new Book("0002", "book2", "John", LocalDate.of(2016, 12, 12)),
				new Book("0001", "book1", "Jon", LocalDate.of(2016, 6, 1)),
				new Book("0003", "book3", "Joan", LocalDate.of(2016, 8, 20))
		);
		ModelAndViewAssert.assertAndReturnModelAttributeOfType(
				mav, "latest", bookList.getClass());
		Comparator<Book> pubDateComparator = (a, b) ->
				a.getPubDate().compareTo(b.getPubDate());
		ModelAndViewAssert.assertSortAndCompareListModelAttribute(
				mav, "latest", bookList, pubDateComparator);
	}
}
