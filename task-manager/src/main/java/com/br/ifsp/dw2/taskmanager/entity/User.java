package com.br.ifsp.dw2.taskmanager.entity;

import com.br.ifsp.dw2.taskmanager.controller.resource.UserResource;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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

    @JsonIgnore
    @NotBlank(message = "Field password is mandatory")
    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_permission"))
    private List<Permission> permissions;

    public User() {
    }

    public User(Long id, @NotBlank(message = "Field name is mandatory") String name,
                @Email @NotBlank(message = "Field email is mandatory") String email,
                @NotBlank(message = "Field password is mandatory") @Size(min = 3, max = 50) String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(@NotBlank(message = "Field name is mandatory") String name,
                @Email @NotBlank(message = "Field email is mandatory") String email,
                @NotBlank(message = "Field password is mandatory") @Size(min = 3, max = 50) String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(Long id, @NotBlank(message = "Field name is mandatory") String name,
                @Email @NotBlank(message = "Field email is mandatory") String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(@NotBlank(message = "Field name is mandatory") String name,
                @Email @NotBlank(message = "Field email is mandatory") String email) {
        this.name = name;
        this.email = email;
    }

    public User(UserResource userResource) {
        this.name = userResource.getName();
        this.email = userResource.getEmail();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
