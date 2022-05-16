package com.jeongho.shopping.controller;

import com.jeongho.shopping.entity.Board;
import com.jeongho.shopping.repository.BoardRepository;
import com.jeongho.shopping.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/board/write")
    public String boardWriteForm(Model model, @RequestParam(required = false) Integer id) {
        if(id == null) {
            model.addAttribute("board", new Board());
        } else{
            Board board = boardService.boardView(id);
            model.addAttribute("board", board);
        }

        return "boardwrite";
    }

    @PostMapping("/board/write")
    public String greetingSubmit(@ModelAttribute Board board){

        boardService.write(board);

        return "redirect:/board/list";
    }


    @GetMapping("/board/list")
    public String boardList(Model model) {

        List<Board> list = boardService.boardList();

        model.addAttribute("list", list);

        return "boardlist";
    }






}
