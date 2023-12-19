package ch.tbz.m450project.book;

import ch.tbz.m450project.util.ValidatorService;

public class BookValidator implements ValidatorService<BookTO> {
	@Override
	public boolean validateRequestBody(BookTO body) {
		return !body.getTitle().isEmpty();
	}
}
