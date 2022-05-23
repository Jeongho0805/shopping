package com.jeongho.shopping.service;

import com.jeongho.shopping.entity.Board;
import com.jeongho.shopping.entity.User;
import com.jeongho.shopping.repository.BoardRepository;
import com.jeongho.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;


    // 글 작성
    public void write(String username, Board board)  {

        User user = userRepository.findByUsername(username);
        board.setUser(user);
        boardRepository.save(board);

    }

    // 게시글 리스트 처리
    public List<Board> boardList() {

        return boardRepository.findAll();
    }



    // 특정 게시글 불러오기
    public Board boardView(Long id) {

        return boardRepository.findById(id).get();

    }

    // 특정 게시글 삭제
    
    public void boardDelete(Long id) {

        boardRepository.deleteById(id);

    }

    // 특정 사용자로 전체 글 조회

    public List<Board> boardUserWrite(String username){

        User user = userRepository.findByUsername(username);

        return boardRepository.findAllByUser(user);

    }
}
