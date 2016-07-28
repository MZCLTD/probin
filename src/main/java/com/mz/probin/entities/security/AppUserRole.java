package com.mz.probin.entities.security;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APP_USER_ROLES")
public class AppUserRole implements Serializable {

    @Id
    @Column(name = "ROLE_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_NAME", nullable = false, unique = true, length = 75)
    private String name;

    @Column(name = "ROLE_DESC")
    private String description;

    public AppUserRole() {}

    public AppUserRole(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
