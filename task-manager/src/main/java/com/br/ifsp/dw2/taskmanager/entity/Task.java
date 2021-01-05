package com.br.ifsp.dw2.taskmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Field description is mandatory")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Field date is mandatory")
    @Column(nullable = false)
    private LocalDate date;

    @NotBlank(message = "Field note is mandatory")
    @Column(nullable = true)
    private String note;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @OneToOne
    private Tag tag;

    public Task() {
    }

    public Task(Long id,
                @NotBlank(message = "Field description is mandatory") String description,
                @NotNull(message = "Field date is mandatory") LocalDate date,
                @NotBlank(message = "Field note is mandatory") String note,
                User user, Tag tag) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.note = note;
        this.user = user;
        this.tag = tag;
    }

    public Task(@NotBlank(message = "Field description is mandatory") String description,
                @NotNull(message = "Field date is mandatory") LocalDate date,
                @NotBlank(message = "Field note is mandatory") String note, User user, Tag tag) {
        this.description = description;
        this.date = date;
        this.note = note;
        this.user = user;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
