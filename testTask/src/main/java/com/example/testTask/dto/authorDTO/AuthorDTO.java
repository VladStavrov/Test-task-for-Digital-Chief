package com.example.testTask.dto.authorDTO;

import com.example.testTask.dto.bookDTO.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private List<BookDTO> books;
}
