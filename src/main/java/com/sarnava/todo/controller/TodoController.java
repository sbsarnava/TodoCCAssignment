package com.sarnava.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sarnava.todo.models.Todo;
import com.sarnava.todo.repository.TodoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<List<Todo>> getAllTodo() {
        return new ResponseEntity<>(todoRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = Todo.builder().description(todo.getDescription()).title(todo.getTitle()).build();
        newTodo = todoRepo.save(newTodo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        Optional<Todo> todo = (Optional<Todo>) todoRepo.findById(id);
        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable Long id) {
        todoRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
