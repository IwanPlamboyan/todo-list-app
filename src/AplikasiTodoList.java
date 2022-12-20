public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    //Menampilkan todoList
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];

            int nomer = i + 1;
            if (todo != null) {
                System.out.println(nomer + " . " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar java Dasar";
        model[1] = "Belajar java OOP";
        showTodoList();
    }

    //Menambahkan Todo ke List
    public static void addTodoList(String todo) {
        //cek apakah model penuh?
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //Jika model penuh maka resize ukuran array 2x lipat
        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi yang data arraynya null
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh to ke. " + i);
        }

        showTodoList();
    }

    //Menghapus Todo dari List
    public static boolean removeTodoList(Integer number) {
        if (number > model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        }else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++) {
                if(i == (model.length - 1)) {
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }
            }
            
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        showTodoList();

        boolean result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi " + name);
    }

    //Menampilkan view todo list
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if(input.equals("x")) {
                break;
            }else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    //Menampilkan view add todo list
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");
        String todo = input("Todo (x Jika Batal)");

        if(todo.equals("x")) {
            //batal
        }else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewAddTodoList();

        showTodoList();
    }

    //Menampilkan view remove todo list
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        String number = input("Nomor yang dihapus (x jika batal)");
        if(number.equals("x")) {
            //batal
        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
