package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        //todoListRepository.data[0] = new TodoList("coba 1");
        //todoListRepository.data[1] = new TodoList("coba 2");
        //todoListRepository.data[2] = new TodoList("coba 3");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Coba 1");
        todoListService.addTodoList("Coba 2");
        todoListService.addTodoList("Coba 3");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Coba 1");
        todoListService.addTodoList("Coba 2");
        todoListService.addTodoList("Coba 3");

        todoListService.removeTodoList(2);

        todoListService.showTodoList();
    }
}
