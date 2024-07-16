package com.example.testTask.mappers;


import com.example.testTask.dto.bookDTO.BookDTO;
import com.example.testTask.dto.bookDTO.CreateBookDTO;

import com.example.testTask.models.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {


    private  final ModelMapper modelMapper;

    public BookDTO toDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book toEntity(CreateBookDTO createBookDTO) {
        return modelMapper.map(createBookDTO, Book.class);
    }

    public void updateEntity(CreateBookDTO createBookDTO, Book book) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(createBookDTO, book);
    }

}
