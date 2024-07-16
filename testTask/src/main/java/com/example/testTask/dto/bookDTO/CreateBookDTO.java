package com.example.testTask.dto.bookDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {
    private Long authorId;
    private String title;
    private int numPages;
}
