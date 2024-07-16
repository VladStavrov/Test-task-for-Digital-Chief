package com.example.testTask.services;


import com.example.testTask.dto.bookDTO.BookDTO;
import com.example.testTask.dto.bookDTO.CreateBookDTO;
import com.example.testTask.mappers.BookMapper;
import com.example.testTask.models.Author;
import com.example.testTask.models.Book;
import com.example.testTask.repositories.AuthorRepository;
import com.example.testTask.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;
    private final BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookDTOById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found with id: " + id));
    }

    public BookDTO createBook(CreateBookDTO createBookDTO) {
        Author author = authorService.getAuthorById(createBookDTO.getAuthorId());


        Book book = bookMapper.toEntity(createBookDTO);
        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    public BookDTO updateBook(Long bookId, CreateBookDTO createBookDTO) {
        Book existingBook = getBookById(bookId);
        Author author = authorService.getAuthorById(createBookDTO.getAuthorId());
        bookMapper.updateEntity(createBookDTO,existingBook);
        existingBook.setAuthor(author);
        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}