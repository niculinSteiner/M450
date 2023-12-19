package ch.tbz.m450project.book;

import java.util.List;

import static ch.tbz.m450project.book.BookConverter.*;

public class BookRepository {
	public static int BOOKS_IN_STORE_COUNTER;
	private final List<BookModel> booksInStore;

	public BookRepository(List<BookModel> booksInStore) {
		this.booksInStore = booksInStore;
		BOOKS_IN_STORE_COUNTER = 0;
	}


	public BookTO addBook(BookTO bookTO) {
		booksInStore.add(convertToObjectModel(bookTO));
		BOOKS_IN_STORE_COUNTER++;
		return bookTO;
	}
}
