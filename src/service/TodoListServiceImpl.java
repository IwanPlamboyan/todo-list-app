package service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;

public class TodoListServiceImpl implements TodoListService{
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            TodoList todolist = model[i];
            int no = i + 1;

            if(todolist != null) {
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Sukses menambahkan todo : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success) {
            System.out.println("Sukses menghapus todo : " + number);
        }else {
            System.out.println("Gagal menghapus todo : " + number);
        }
    }
}
