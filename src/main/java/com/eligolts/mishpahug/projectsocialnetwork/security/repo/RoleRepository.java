package com.eligolts.mishpahug.projectsocialnetwork.security.repo;

import com.eligolts.mishpahug.projectsocialnetwork.model.Role;
import com.eligolts.mishpahug.projectsocialnetwork.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository <Role,Long> {

    Role getRoleByStatus(Status status);

    Role getRoleByRoleId(Long roleId);

    List<Role> getAllBy();

}
