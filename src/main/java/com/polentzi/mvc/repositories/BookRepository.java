package com.polentzi.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.polentzi.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
    List<Book> findAll();
    
    List<Book> findByDescriptionContaining(String search);
   
    Long countByTitleContaining(String search);
   
    Long deleteByTitleStartingWith(String search);
   
    Optional<Book> findById(Long id);
   
	void deleteById(Long id);
}