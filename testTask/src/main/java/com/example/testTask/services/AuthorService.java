package com.example.testTask.services;

import com.example.testTask.dto.authorDTO.AuthorDTO;
import com.example.testTask.dto.authorDTO.CreateAuthorDTO;
import com.example.testTask.dto.bookDTO.BookDTO;
import com.example.testTask.mappers.AuthorMapper;
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
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AuthorDTO> getAuthorDTOById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDTO);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with id: " + id));
    }

    public AuthorDTO createAuthor(CreateAuthorDTO createAuthorDTO) {
        Author author = authorMapper.toEntity(createAuthorDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(savedAuthor);
    }
    public AuthorDTO updateAuthor(Long authorId, CreateAuthorDTO createAuthorDTO) {
        Author existingAuthor = getAuthorById(authorId);
        authorMapper.updateEntity(createAuthorDTO,existingAuthor);
        Author updatedAuthor = authorRepository.save(existingAuthor);
        return authorMapper.toDTO(updatedAuthor);
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}