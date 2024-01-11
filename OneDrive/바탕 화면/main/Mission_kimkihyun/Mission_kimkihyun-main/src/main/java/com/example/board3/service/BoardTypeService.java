package com.example.board3.service;

import com.example.board3.entity.BoardType;
import com.example.board3.repository.BoardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BoardTypeService {

    @Autowired
    private BoardTypeRepository boardTypeRepository;

    public List<BoardType> findAll() {
        return boardTypeRepository.findAll();
    }
    public BoardType findById(Integer id) {
        return boardTypeRepository.findById(id).get();
    }
}
