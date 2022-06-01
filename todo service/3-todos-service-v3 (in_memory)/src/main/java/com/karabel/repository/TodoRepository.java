package com.karabel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karabel.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
