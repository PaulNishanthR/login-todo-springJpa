package com.codewithnishanth.logintodospringJpa.repository;

import com.codewithnishanth.logintodospringJpa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRespository extends JpaRepository<Todo, Integer> {
}
