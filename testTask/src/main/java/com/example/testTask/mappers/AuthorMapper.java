package com.example.testTask.mappers;

import com.example.testTask.dto.authorDTO.AuthorDTO;
import com.example.testTask.dto.authorDTO.CreateAuthorDTO;
import com.example.testTask.models.Author;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private  final ModelMapper modelMapper;

    public AuthorDTO toDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public Author toEntity(CreateAuthorDTO createAuthorDTO) {
        return modelMapper.map(createAuthorDTO, Author.class);
    }

    public void updateEntity(CreateAuthorDTO createAuthorDTO, Author author) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(createAuthorDTO, author);
    }
}
