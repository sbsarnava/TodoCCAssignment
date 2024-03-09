package com.sarnava.todo.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.sarnava.todo.models.Todo;

public interface TodoRepository extends ListCrudRepository<Todo, Long> {
}
