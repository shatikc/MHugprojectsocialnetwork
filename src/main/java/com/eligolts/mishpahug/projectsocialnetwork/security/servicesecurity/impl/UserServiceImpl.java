package com.eligolts.mishpahug.projectsocialnetwork.security.servicesecurity.impl;

import com.eligolts.mishpahug.projectsocialnetwork.model.Role;
import com.eligolts.mishpahug.projectsocialnetwork.model.Status;
import com.eligolts.mishpahug.projectsocialnetwork.security.repo.RoleRepository;
import com.eligolts.mishpahug.projectsocialnetwork.security.repo.UserRepository;
import com.eligolts.mishpahug.projectsocialnetwork.security.servicesecurity.UserService;
import com.eligolts.mishpahug.projectsocialnetwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*implementation of {@link UserService} interface
*
* @author Eli Golts */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = encoder;
    }

    @Override
    @Transactional
    public User registration(User user) {

        /*Setup new role for new user*/
        Role beginUser  = roleRepository.getRoleByStatus(Status.USER_ROLE);
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(beginUser);
        user.setRoles(userRoles);

        /*Setup new user for role. It's need for connections between them*/
        List<User> rolesOfUser = beginUser.getUsers();
        rolesOfUser.add(user);
        beginUser.setUsers(rolesOfUser);

        /*Setup encoding password for new user*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        /*And save them in DB and gonna be drink coffee*/
        User registeredUser = userRepository.save(user);
        roleRepository.save(beginUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByUserName(String name) {
        return null;
    }

    @Override
    public User findById(Long userId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
