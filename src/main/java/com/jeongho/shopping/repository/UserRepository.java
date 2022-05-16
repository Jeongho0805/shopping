package com.jeongho.shopping.repository;

import com.jeongho.shopping.entity.Board;
import com.jeongho.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
