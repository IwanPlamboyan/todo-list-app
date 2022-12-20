package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{
    private TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        //cek apakah model penuh?
        boolean isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        //Jika model penuh maka resize ukuran array 2x lipat
        if (isFull()) {
            TodoList[] temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todolist) {
        resizeIfFull();

        //tambahkan ke posisi yang data arraynya null
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (number > data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        }else {
            data[number - 1] = null;

            for (int i = (number - 1); i < data.length; i++) {
                if(i == (data.length - 1)) {
                    data[i] = null;
                }else {
                    data[i] = data[i + 1];
                }
            }

            return true;
        }
    }
}
