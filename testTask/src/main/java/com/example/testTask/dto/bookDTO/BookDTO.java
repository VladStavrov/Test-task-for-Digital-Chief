package com.example.testTask.dto.bookDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long authorId;
    private Long id;
    private String title;
    private int numPages;
}
