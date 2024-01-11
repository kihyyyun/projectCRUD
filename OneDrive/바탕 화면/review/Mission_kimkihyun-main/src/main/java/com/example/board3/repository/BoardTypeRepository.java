package com.example.board3.repository;

import com.example.board3.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTypeRepository extends JpaRepository<BoardType,Integer> {
}
