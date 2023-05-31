package com.polentzi.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.polentzi.mvc.models.Book;
import com.polentzi.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //edits a book
    public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
    	Optional <Book> update = bookRepository.findById(id);
    	if(update != null && update.isPresent()) {
    		update.get().setTitle(title);
    		update.get().setDescription(description);
    		update.get().setNumberOfPages(numOfPages);
    		bookRepository.save(update.get());
    		return update.get();
    	}
    	return null;        
    }

    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
