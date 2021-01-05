package com.br.ifsp.dw2.taskmanager.entity;

import com.br.ifsp.dw2.taskmanager.controller.resource.TagResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Field name is mandatory")
    @Column(nullable = false, unique = true)
    private String name;

    public Tag(Long id, @NotBlank(message = "Field name is mandatory") String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(TagResource tagResource) {
        this.name = tagResource.getName();
    }

    public Tag() {

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
}
