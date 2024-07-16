package com.example.testTask.dto.authorDTO;

import com.example.testTask.dto.bookDTO.BookDTO;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long id;

    @Size(min = 3, message = "First name must be at least 3 characters long")
    private String firstName;

    @Size(min = 3, message = "Last name must be at least 3 characters long")
    private String lastName;

    private List<BookDTO> books;
}
