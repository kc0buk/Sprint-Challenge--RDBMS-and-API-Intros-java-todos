package com.lambdaschool.todos.services;


import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService {

    @Autowired
    TodoRepository todorepo;

    @Autowired
    UserService userService;

    @Override
    public void markComplete(long todoid) {

    }

    @Transactional
    @Override
    public Todo save(long userid, Todo todo) {
        User currentUser = userService.findUserById(userid);
        Todo newTodo = new Todo(currentUser, todo.getDescription());
        todorepo.save(newTodo);
        return newTodo;
    }

}
