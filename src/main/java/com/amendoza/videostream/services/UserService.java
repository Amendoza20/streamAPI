package com.amendoza.videostream.services;

import com.amendoza.videostream.models.User;
import com.amendoza.videostream.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Iterable<User> findAllUser() {
        return repository.findAll();
    }

    public User addUser(User user) {
        return repository.save(user);
    }
    public User login(String username, String password){
        User user = repository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public Boolean deleteByUsername(String username) {
        User user = findByUsername(username);
        if (user != null) {
            repository.delete(user);
            return true;
        }

        return false;
    }
}


