package com.example.testTask.dto.bookDTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long authorId;
    private Long id;

    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    @Min(value = 3, message = "Number of pages must be at least 3")
    private int numPages;
}
