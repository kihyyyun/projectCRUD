package com.example.board3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BoardType {
    @Id
    private Integer id;
    private String boardName;
}
