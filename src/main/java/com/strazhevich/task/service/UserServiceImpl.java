package com.strazhevich.task.service;

import com.strazhevich.task.entity.User;
import com.strazhevich.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Denis Strazhevich
 */

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        expectation();
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        expectation();
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        expectation();
        return userRepository.findOne(id);
    }

    private void expectation(){
        long ms = 5000 + (long) (Math.random() * 10000);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
