package com.example.testTask.controllers;


import com.example.testTask.dto.authorDTO.AuthorDTO;
import com.example.testTask.dto.authorDTO.CreateAuthorDTO;
import com.example.testTask.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        Optional<AuthorDTO> authorDTO = authorService.getAuthorDTOById(id);
        return authorDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody CreateAuthorDTO createAuthorDTO) {
        AuthorDTO authorDTO = authorService.createAuthor(createAuthorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody CreateAuthorDTO createAuthorDTO) {
        AuthorDTO updatedAuthor = authorService.updateAuthor(id, createAuthorDTO);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}