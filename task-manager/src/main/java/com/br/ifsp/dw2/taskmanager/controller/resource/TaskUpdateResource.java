package com.br.ifsp.dw2.taskmanager.controller.resource;

import com.br.ifsp.dw2.taskmanager.entity.Task;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

public class TaskUpdateResource {

    @NotBlank(message = "Field description is mandatory")
    private String description;

    private LocalDate date;

    private String note;

    @NotBlank(message = "Field Id Tag is mandatory")
    private Long tag;


    public TaskUpdateResource(@NotBlank(message = "Field description is mandatory") String description,
                        LocalDate date, String note,
                        @NotBlank(message = "Field Id User is mandatory") Long user,
                        @NotBlank(message = "Field Id Tag is mandatory") Long tag) {
        this.description = description;
        this.date = date;
        this.note = note;
        this.tag = tag;
    }

    public TaskUpdateResource(Task task) {
        this.description = task.getDescription();
        this.date = task.getDate();
        this.note = task.getNote();
        this.tag = task.getTag().getId();
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
        this.date = Objects.requireNonNullElseGet(date, LocalDate::now);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getTag() {
        return tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }
}
