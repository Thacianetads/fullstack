package com.dev.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.todolist.entity.Todo;
import com.dev.todolist.exception.TodoNotFoundException;
import com.dev.todolist.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return read();
    }

    public List<Todo> read(){
        Sort sort = Sort.by("priority").descending().and(
            Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo){
        
        Optional<Todo> existingTodo = todoRepository.findById(todo.getId());

        if (existingTodo.isPresent()){
            Todo updatedTodo = existingTodo.get();

            // Atualiza apenas os campos que foram enviados
            if(todo.getname() != null) updatedTodo.setname(todo.getname());
            
            // Atualiza a descrição se não for nula
            if (todo.getdescription() != null) updatedTodo.setdescription(todo.getdescription());

            // Atualiza o status de completado se não for nulo
            if (todo.iscompleted() != updatedTodo.iscompleted()) updatedTodo.setcompleted(todo.iscompleted());

            // Atualiza a prioridade se não for a mesma que já está
            if (todo.getpriority() != updatedTodo.getpriority()) updatedTodo.setpriority(todo.getpriority());

            // Salva o Todo atualizado no banco
            todoRepository.save(updatedTodo);
            return read();
        }else{
            throw new TodoNotFoundException("Todo not found with id : "+ todo.getId());
        }

        
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return read();
    }

    public Todo getById(Long id) {

        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
}
}
