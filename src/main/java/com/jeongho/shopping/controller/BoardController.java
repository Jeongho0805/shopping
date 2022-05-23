package com.jeongho.shopping.controller;

import com.jeongho.shopping.entity.Board;
import com.jeongho.shopping.repository.BoardRepository;
import com.jeongho.shopping.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
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
    public String boardWriteForm(Model model, @RequestParam(required = false) Long id) {
        if(id == null) {
            model.addAttribute("board", new Board());
        } else{
            Board board = boardService.boardView(id);
            model.addAttribute("board", board);
        }

        return "boardwrite";
    }

    @PostMapping("/board/write")
    public String greetingSubmit(@ModelAttribute Board board, Authentication authentication) {

        String username = authentication.getName();
        boardService.write(username, board);

        return "redirect:/board/list";
    }


    @GetMapping("/board/list")
    public String boardList(Model model) {

        List<Board> list = boardService.boardList();

        model.addAttribute("list", list);

        return "boardlist";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Long id ) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }


    // 특정 사용자가 쓴 글 전체 표시 기능
    @GetMapping("/board/user")
    public String boardUserWriteList(Model model, @RequestParam String name){

        List<Board> list =  boardService.boardUserWrite(name);

        model.addAttribute("list", list);

        return "boardlist";

    }







}
