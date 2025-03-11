package com.akri.book_inventory;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akri.book_inventory.model.Book;
import com.akri.book_inventory.model.User;
import com.akri.book_inventory.repos.BookRepository;
import com.akri.book_inventory.repos.UserRepository;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired

    
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Book>> getBooksByUser(@PathVariable Long id) {//@pathvariable is used to take user id from the url
        Optional<User> user = userRepository.findById(id);//Optional is used to provide a container that may or may not contain null value,help avoid null check
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Book> books = bookRepository.findByUserId(id);
        return ResponseEntity.ok(books);
    }

    // Add a new book linked to a user
    @PostMapping("/user/{id}")
    public ResponseEntity<Book> addBook(@PathVariable Long id, @Validated @RequestBody Book book) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        book.setUser(user.get());
        
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    
            
    }
    //Update the book information linked to a user
    @PutMapping("/book/{id}")
public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    
        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Retrieve the existing book and update fields
        Book existingBook = optionalBook.get();
        existingBook.setName(bookDetails.getName());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setGenre(bookDetails.getGenre());
        if (bookDetails.getUser() != null) {
            Optional<User> optionalUser = userRepository.findById(bookDetails.getUser().getUser_id());
            optionalUser.ifPresent(existingBook::setUser);
        }
        // Save the updated book
        Book savedBook = bookRepository.save(existingBook);
        
        return ResponseEntity.ok(savedBook);
    }

    
    
    
    


}
