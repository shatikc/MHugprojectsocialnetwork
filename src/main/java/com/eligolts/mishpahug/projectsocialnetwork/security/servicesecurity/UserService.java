package com.eligolts.mishpahug.projectsocialnetwork.security.servicesecurity;

import com.eligolts.mishpahug.projectsocialnetwork.model.User;

import java.util.List;

public interface UserService {

    User registration(User user);

    List<User> getAll();

    User findByUserName(String name);

    User findById(Long userId);

    void delete (Long id);

}
