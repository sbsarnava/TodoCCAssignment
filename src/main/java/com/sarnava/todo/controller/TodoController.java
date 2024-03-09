package com.sarnava.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sarnava.todo.models.Todo;
import com.sarnava.todo.repository.TodoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("todo")
@AllArgsConstructor
public class TodoController {

    private final TodoRepository todoRepo;

    @GetMapping("")
    public List<Todo> getMethodName() {
        return todoRepo.findAll();
    }

    @PostMapping("")
    public Todo postMethodName(@RequestBody Todo todo) {
        return todoRepo.save(todo);
    }

    @GetMapping("/{id}")
    public Optional<Todo> getMethodName(@PathVariable Long id) {
        return todoRepo.findById(id);
    }

}
