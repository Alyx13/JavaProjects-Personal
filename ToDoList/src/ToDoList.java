import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<String>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= tasks.size()) {
            System.out.println("Invalid index.");
            return;
        }
        String task = tasks.get(index);
        tasks.remove(index);
        System.out.println("Task removed: " + task);
    }

    public void editTask(int index, String newTask) {
        if (index >= tasks.size()) {
            System.out.println("Invalid index.");
            return;
        }
        String task = tasks.get(index);
        tasks.set(index, newTask);
        System.out.println("Task edited: " + task + " -> " + newTask);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, remove, edit, print, exit): ");
            String command = scanner.nextLine();
            if (command.equals("add")) {
                System.out.println("Enter task: ");
                String task = scanner.nextLine();
                todoList.addTask(task);
            } else if (command.equals("remove")) {
                System.out.println("Enter index: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                todoList.removeTask(index);
            } else if (command.equals("edit")) {
                System.out.println("Enter index: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new task: ");
                String newTask = scanner.nextLine();
                todoList.editTask(index, newTask);
            } else if (command.equals("print")) {
                todoList.printTasks();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}