package com.karabel.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import com.karabel.entity.Todo;
import com.karabel.entity.TodoType;

@RestController
public class TodosController {

	private static Map<Integer, Todo> in_memory_todos_db = new HashMap<>();

	// ---------------------------------------------------
	static {
		in_memory_todos_db.put(1, new Todo(1, "todo-1", true,TodoType.HOME));
		in_memory_todos_db.put(2, new Todo(2, "todo-2", false, TodoType.OFFICE));
		in_memory_todos_db.put(3, new Todo(3, "todo-3", true,TodoType.HOME));
		in_memory_todos_db.put(4, new Todo(4, "todo-4", false, TodoType.OFFICE));
		in_memory_todos_db.put(5, new Todo(5, "todo-5", true,TodoType.HOME));
		in_memory_todos_db.put(6, new Todo(6, "todo-6", false, TodoType.OFFICE));
	}
	// ---------------------------------------------------

	// GET : /api/todos

	@RequestMapping(
			method = RequestMethod.GET,
			value="/api/todos",
			produces = {"application/json","application/xml"},
			params = {"type","!limit"}
			)
	public Collection<Todo> getAll(
			@RequestParam(name="type", required=false) String type
		)
	{
		if(type==null) {
			return in_memory_todos_db.values();
		}
		return in_memory_todos_db.values()
				.stream()
				.filter(todo -> todo.getType()
						.equals(TodoType.valueOf(type.toUpperCase())))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/api/todos",
			produces = {"application/json","application/xml"},
			params = {"type","limit"}
			)
	
	public Collection<Todo> getByLimit(
			@RequestParam(name = "type") String type,
			@RequestParam(name = "limit") int limit
			){
		return in_memory_todos_db.values()
				.stream()
				.filter(todo -> todo.getType().equals(TodoType.valueOf(type.toUpperCase())))
				.collect(Collectors.toList())
				.subList(0, limit);
	}
	
	// ---------------------------------------------------
	
	

		
	
	

	// GET : /api/todos/{todoId}

	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/api/todos/{todoId}",
			produces = { "application/json"}
			)
	public ResponseEntity<?> get(@PathVariable(name = "todoId") int todoId) {
		Todo todo = in_memory_todos_db.get(todoId);
		if(todo!= null) {
			return ResponseEntity.ok(todo);
		}else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	// ---------------------------------------------------

	
	// POST : /api/todos
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/api/todos",
			consumes = {"application/json","application/xml"}
			)
	
	public ResponseEntity<?> post(@RequestBody Todo todo) {
		todo.setId(in_memory_todos_db.size()+1);
		in_memory_todos_db.put(in_memory_todos_db.size()+1, todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(todo);
		
	}
	// ---------------------------------------------------
	
	// PUT : /api/todos/{todoId}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			value = "/api/todos/{todoId}",
			consumes = {"application/json","application/xml"}
			)
	
	public ResponseEntity<?> put(
			@PathVariable(name="todoId") int todoId,
			@RequestBody Todo todo
			) {
		
		Todo existingTodo = in_memory_todos_db.get(todoId);
		if(existingTodo == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else {
			existingTodo.setTitle(todo.getTitle());
			existingTodo.setCompleted(todo.isCompleted());
			return ResponseEntity.status(HttpStatus.OK).build();
		}		
	}
	
	// ---------------------------------------------------
	
	// DELETE : /api/todos/{todoId}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			value = "/api/todos/{todoId}",
			consumes = {"application/json","application/xml"}
			)
	
	public ResponseEntity<?> delete(
			@PathVariable(name="todoId") int todoId,
			@RequestBody Todo todo
			){
		Todo todoremove = in_memory_todos_db.get(todoId);
		if(todoremove==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			in_memory_todos_db.remove(todoremove.getId());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}
	
	
}
