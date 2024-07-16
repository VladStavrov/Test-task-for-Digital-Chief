package com.example.testTask.dto.authorDTO;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorDTO {
    @Size(min = 3, message = "First name must be at least 3 characters long")
    private String firstName;

    @Size(min = 3, message = "Last name must be at least 3 characters long")
    private String lastName;
}
