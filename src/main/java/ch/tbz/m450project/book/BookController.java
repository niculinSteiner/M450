package ch.tbz.m450project.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "book")
@CrossOrigin("*")
public class BookController {

	BookRepository bookRepository = new BookRepository(new ArrayList<>());

	BookValidator bookValidator = new BookValidator();

	@PostMapping(value = "/add")
	public ResponseEntity<BookTO> addBookToStore(@RequestBody BookTO bookTO) {
		if (!bookValidator.validateRequestBody(bookTO)){
			return ResponseEntity.status(404).body(bookTO);
		}
		return ResponseEntity.status(201).body(bookRepository.addBook(bookTO));
	}
}
