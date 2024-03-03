import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private ArrayList<String> tasks;

    public ToDoListApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String completedTask = tasks.get(index);
            tasks.remove(index);
            System.out.println("Task marked as complete: " + completedTask);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display tasks");
            System.out.println("4. Mark task as complete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Add this line

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int index = scanner.nextInt();
                    app.deleteTask(index);
                    break;
                case 3:
                    app.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as complete: ");
                    int taskIndex = scanner.nextInt();
                    app.markTaskAsComplete(taskIndex);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}