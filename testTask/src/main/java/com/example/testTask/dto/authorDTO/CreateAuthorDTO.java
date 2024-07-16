package com.example.testTask.dto.authorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorDTO {
    private String firstName;
    private String lastName;
}
