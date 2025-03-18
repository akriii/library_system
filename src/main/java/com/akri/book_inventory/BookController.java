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

import com.akri.book_inventory.model.Administrator;
import com.akri.book_inventory.model.Book;
import com.akri.book_inventory.repos.AdministratorRepository;
import com.akri.book_inventory.repos.BookRepository;
import com.akri.book_inventory.repos.BorrowedRepository;
import com.akri.book_inventory.repos.PaymentRepository;
import com.akri.book_inventory.repos.UserRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final AdministratorRepository adminRepository;
    private final BorrowedRepository borrowedRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public BookController(BookRepository bookRepository, UserRepository userRepository, 
                          AdministratorRepository adminRepository, BorrowedRepository borrowedRepository, 
                          PaymentRepository paymentRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.borrowedRepository = borrowedRepository;
        this.paymentRepository = paymentRepository;
    }

    // ✅ Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    

    // ✅ Get books borrowed by a user
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Book>> getBooksByUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        List<Book> books = bookRepository.findByBorrowed_User_Id(id);  // Fixed Query
        return ResponseEntity.ok(books);
    }

    // ✅ Add a new book (linked to an Admin)
    @PostMapping("/admin/{adminId}")
    public ResponseEntity<Book> addBook(@PathVariable Long adminId, @Validated @RequestBody Book book) {
        Optional<Administrator> admin = adminRepository.findById(adminId);
        if (admin.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        book.setAdmin(admin.get());  // Assign the book to an admin
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // ✅ Update book details (Admin updates the book)
    @PutMapping("/{id}/admin/{adminId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @PathVariable Long adminId, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Administrator> admin = adminRepository.findById(adminId);
        if (admin.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Book existingBook = optionalBook.get();
        existingBook.setName(bookDetails.getName());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setGenre(bookDetails.getGenre());
        existingBook.setCopies(bookDetails.getCopies());
        existingBook.setPricePerDay(bookDetails.getPricePerDay());
        existingBook.setAdmin(admin.get());

        Book updatedBook = bookRepository.save(existingBook);
        return ResponseEntity.ok(updatedBook);
    }
}
