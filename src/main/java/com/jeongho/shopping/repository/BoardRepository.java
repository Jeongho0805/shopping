package com.jeongho.shopping.repository;

import com.jeongho.shopping.entity.Board;
import com.jeongho.shopping.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByUser(User user);

}
