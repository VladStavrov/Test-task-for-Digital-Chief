package com.example.testTask.controllers;


import com.example.testTask.dto.bookDTO.BookDTO;
import com.example.testTask.dto.bookDTO.CreateBookDTO;
import com.example.testTask.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> bookDTO = bookService.getBookDTOById(id);
        return bookDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid CreateBookDTO createBookDTO) {
        BookDTO bookDTO = bookService.createBook(createBookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@Valid @RequestBody CreateBookDTO createBookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, createBookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}