package com.example.board3.service;

import com.example.board3.entity.Board;
import com.example.board3.entity.BoardType;
import com.example.board3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    @Autowired // 스프링 컨테이너에서 빈 자동주입
    private BoardRepository boardRepository;
    private BoardTypeService boardTypeService;
    //글 작성
    public void create(Board board){
        boardRepository.save(board);
    }

    //젠체게시판 조회
    public List<Board> boards(){
        return boardRepository.findAll();
    }
    //특정 게시글 조회
    public Board view(Long id){
        return boardRepository.findById(id).get();
    }

    //작성글 삭제
    public void delete(Long id){
        boardRepository.deleteById(id);
    }
}
