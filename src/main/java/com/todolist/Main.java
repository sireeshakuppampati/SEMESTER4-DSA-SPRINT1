package com.todolist;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[10]; // Assuming a maximum of 10 users for simplicity
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("To-Do List Manager");
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void createUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        if (userCount < users.length) {
            users[userCount++] = new User(name);
            System.out.println("User created successfully.");
        } else {
            System.out.println("User limit reached.");
        }
    }

    private static void addTask(Scanner scanner) {
        User user = findUser(scanner);
        if (user != null) {
            System.out.print("Enter task description: ");
            String taskDescription = scanner.nextLine();
            user.addTask(taskDescription);
            System.out.println("Task added successfully.");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        User user = findUser(scanner);
        if (user != null) {
            System.out.print("Enter task description to mark as completed: ");
            String taskDescription = scanner.nextLine();
            user.markTaskAsCompleted(taskDescription);
        }
    }

    private static void viewTasks(Scanner scanner) {
        User user = findUser(scanner);
        if (user != null) {
            user.viewTasks();
        }
    }

    private static User findUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        for (User user : users) {
            if (user != null && user.getName().equals(name)) {
                return user;
            }
        }
        System.out.println("User not found!");
        return null;
    }
}
