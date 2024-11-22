// File: main/Main.java
package main;

import model.User;
import service.UserService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("\nUser Management System");
            System.out.println("1. Create User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Create User
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    User user = userService.createUser(name);
                    System.out.println("User created: " + user);
                    break;

                case 2: // View Users
                    System.out.println("Users List:");
                    userService.getAllUsers().forEach(System.out::println);
                    break;

                case 3: // Update User
                    System.out.print("Enter user ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    User existingUser = userService.getUserById(updateId);
                    if (existingUser != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        User updatedUser = userService.updateUser(updateId, newName);
                        System.out.println("Updated User: " + updatedUser);
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 4: // Delete User
                    System.out.print("Enter user ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleted = userService.deleteUser(deleteId);
                    if (deleted) {
                        System.out.println("User deleted successfully.");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
