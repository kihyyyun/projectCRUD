package com.example.board3.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
public class Board {
    @GeneratedValue
    @Id
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name ="board_type_id")
    private BoardType boardType;


    public Board(String title, String content){
        this.title = title;
        this.content =content;
    }
}
