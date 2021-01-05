package com.br.ifsp.dw2.taskmanager.controller.resource;

import com.br.ifsp.dw2.taskmanager.entity.Tag;

import javax.validation.constraints.NotBlank;

public class TagResource {

    @NotBlank(message = "Field name is mandatory")
    private String name;

    public TagResource() {
    }

    public TagResource(@NotBlank(message = "Field name is mandatory") String name) {
        this.name = name;
    }

    public TagResource(Tag tag) {
        this.name = tag.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
