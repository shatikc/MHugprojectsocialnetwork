package com.eligolts.mishpahug.projectsocialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    List<User> users;

    public Role(Status status, List<User> users) {
        this.status = status;
        this.users = users;
    }
}
