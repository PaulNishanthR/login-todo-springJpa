package com.codewithnishanth.logintodospringJpa.service;

import com.codewithnishanth.logintodospringJpa.model.AppUser;
import com.codewithnishanth.logintodospringJpa.model.Todo;
import com.codewithnishanth.logintodospringJpa.repository.AppUserRepository;
import com.codewithnishanth.logintodospringJpa.repository.TodoRespository;
import com.codewithnishanth.logintodospringJpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRespository todoRespository;

    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> findAll(int userId) {
        return todoRespository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> addTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUser_id()).get();
        originalTodo.setAppUser(user);
        todoRespository.save(originalTodo);
        return findAll(todo.getUser_id());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUser_id()).get();
        originalTodo.setAppUser(user);
        todoRespository.save(originalTodo);
        return findAll(todo.getUser_id());
    }

    public List<Todo> delete(Integer id) {
        int userId = todoRespository.findById(id).get().getAppUser().getId();
        todoRespository.deleteById(id);
        return findAll(userId);
    }
}