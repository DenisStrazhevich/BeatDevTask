package com.strazhevich.task.service;

import com.strazhevich.task.entity.User;

import java.util.List;

/**
 * Service interface for {@link User} class
 *
 * @author Denis Strazhevich
 */

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(Integer id);
}
