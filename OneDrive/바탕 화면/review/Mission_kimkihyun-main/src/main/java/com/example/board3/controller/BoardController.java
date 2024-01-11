package com.example.board3.controller;

import com.example.board3.entity.Board;
import com.example.board3.entity.BoardType;
import com.example.board3.service.BoardService;
import com.example.board3.service.BoardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {



    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardTypeService boardTypeService;

    //홈
    @GetMapping("/index")
    public String Home(Model model){
        return "index";
    }

    //글 작성
    @GetMapping("/write")
    public String writeForm(Model model){
        List<BoardType> boardTypes = boardTypeService.findAll();
        model.addAttribute("boardTypes", boardTypes);
        return "boardwrite";
    }

    @PostMapping("/board/write")
    public String boardWritePro(Board board){
        boardService.create(board);
        return "redirect:/board/list";
    }



    //전체 게시판 조회
    @GetMapping("/board/list")
    public String boradList(Model model){
        model.addAttribute("list",boardService.boards());

        return "boardlist";
    }


    //게시글 상세페이지
    @GetMapping("/board/view")
    public String boardView(Model model,@RequestParam("id") Long id){

        model.addAttribute("board",boardService.view(id));
        return "boardview";
    }


    //글삭제
    @GetMapping("/board/delete")
    public String boardDelete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }

    //글수정
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Long id ,Model model){

        model.addAttribute("board", boardService.view(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id")Long id,Board board){

        Board boardTemp =boardService.view(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.create(boardTemp);

        return "redirect:/board/list";
    }
}

