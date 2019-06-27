package com.eligolts.mishpahug.projectsocialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter



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
    private List<User> users;

    public Role(Status status, List<User> users) {
        this.status = status;
        this.users = users;
    }

    public long getRoleId() {
        return roleId;
    }

    public Status getStatus() {
        return status;
    }

    public List<User> getUsers() {
        return users;
    }
}
