package ch.tbz.m450project.book;

import java.awt.print.Book;

import static ch.tbz.m450project.book.BookRepository.*;

public class BookConverter {

	public static BookTO convertToTO(BookModel model) {
		return new BookTO(model.getTitle());
	}

	public static BookModel convertToObjectModel(BookTO TO) {
		return new BookModel(BOOKS_IN_STORE_COUNTER, TO.getTitle());
	}
}
