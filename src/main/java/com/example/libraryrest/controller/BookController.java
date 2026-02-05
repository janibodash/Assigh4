package com.example.libraryrest.controller;

import com.example.libraryrest.entities.Book;
import com.example.libraryrest.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // POST add book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            return "Book not found";
        }
        bookRepository.deleteById(id);
        return "Book deleted";
    }

    @PutMapping("/{id}")
    public String updateBook(
            @PathVariable Integer id,
            @RequestBody Book updatedBook
    ) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setYear(updatedBook.getYear());
                    book.setDescription(updatedBook.getDescription());
                    bookRepository.save(book);
                    return "Book updated";
                })
                .orElse("Book not found");
    }

    @PutMapping("/{id}/year")
    public String updateYear(
            @PathVariable Integer id,
            @RequestBody Book book
    ) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setYear(book.getYear());
                    bookRepository.save(b);
                    return "Year updated";
                })
                .orElse("Book not found");
    }

    @PutMapping("/{id}/description")
    public String updateDescription(
            @PathVariable Integer id,
            @RequestBody Book book
    ) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setDescription(book.getDescription());
                    bookRepository.save(b);
                    return "Description updated";
                })
                .orElse("Book not found");
    }

    @PutMapping("/{id}/title")
    public String updateTitle(
            @PathVariable Integer id,
            @RequestBody Book book
    ) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setTitle(book.getTitle());
                    bookRepository.save(b);
                    return "Title updated";
                })
                .orElse("Book not found");
    }

    @PutMapping("/{id}/author")
    public String updateAuthor(
            @PathVariable Integer id,
            @RequestBody Book book
    ) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setAuthor(book.getAuthor());
                    bookRepository.save(b);
                    return "Author updated";
                })
                .orElse("Book not found");
    }





}
