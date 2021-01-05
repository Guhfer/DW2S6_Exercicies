package com.br.ifsp.dw2.taskmanager.entity;

import com.br.ifsp.dw2.taskmanager.controller.resource.UserResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Field name is mandatory")
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank(message = "Field email is mandatory")
    @Column(nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(Long id, @NotBlank(message = "Field name is mandatory") String name,
                @Email @NotBlank(message = "Field email is mandatory") String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(@NotBlank(message = "Field name is mandatory") String name, @Email @NotBlank(message = "Field email is mandatory") String email) {
        this.name = name;
        this.email = email;
    }

    public User(UserResource userResource) {
        this.name = userResource.getName();
        this.email = userResource.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
