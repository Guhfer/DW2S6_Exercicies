package com.br.ifsp.dw2.taskmanager.controller.resource;

import com.br.ifsp.dw2.taskmanager.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserResource {

    @NotBlank(message = "Field name is mandatory")
    private String name;

    @Email
    @NotBlank(message = "Field email is mandatory")
    private String email;

    public UserResource(@NotBlank(message = "Field name is mandatory") String name,
                        @Email @NotBlank(message = "Field email is mandatory") String email) {
        this.name = name;
        this.email = email;
    }

    public UserResource(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
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
