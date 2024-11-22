// File: service/UserService.java
package service;

import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<User> users = new ArrayList<>();
    private int currentId = 1;  // to simulate auto-incremented IDs

    // Create
    public User createUser(String name) {
        User user = new User(currentId++, name);
        users.add(user);
        return user;
    }

    // Read
    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        return user.orElse(null); // return null if not found
    }

    // Update
    public User updateUser(int id, String newName) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(newName);
            return user;
        }
        return null; // return null if user not found
    }

    // Delete
    public boolean deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false; // return false if user not found
    }
}
