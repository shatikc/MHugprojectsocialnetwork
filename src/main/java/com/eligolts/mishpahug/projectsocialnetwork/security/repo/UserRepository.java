package com.eligolts.mishpahug.projectsocialnetwork.security.repo;

import com.eligolts.mishpahug.projectsocialnetwork.model.Status;
import com.eligolts.mishpahug.projectsocialnetwork.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByUsername(String username);

    User getUserByUserId(Long userId);

    List<User> getUserByRolesOrderByUserId(Status status);

}
