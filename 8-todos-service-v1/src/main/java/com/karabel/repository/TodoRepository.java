package com.karabel.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.karabel.entity.Todo;

@Transactional
public interface TodoRepository extends CrudRepository<Todo, Integer>{
	
	// save
	// findTodoById
	// findAll
	// update
	// delete
}
