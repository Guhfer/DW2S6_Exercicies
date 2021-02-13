package com.br.ifsp.dw2.taskmanager.controller;

import com.br.ifsp.dw2.taskmanager.controller.resource.TaskResource;
import com.br.ifsp.dw2.taskmanager.controller.resource.TaskUpdateResource;
import com.br.ifsp.dw2.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResource> create(@Valid @RequestBody TaskResource taskResource) {
        try {
            return new ResponseEntity<>(taskService.saveTask(taskResource), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping("/find-by-description/{description}")
    public ResponseEntity<TaskResource> getTaskByDescription(@PathVariable String description) {
        try {
            return new ResponseEntity<>(taskService.findTaskByDescription(description), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResource> getTaskById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResource> updateTaskById(@PathVariable Long id,
                                                       @Valid @RequestBody TaskUpdateResource taskUpdateResource) {
        try {
            return new ResponseEntity<>(taskService.updateById(id, taskUpdateResource), HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskResource>> getAll() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        try {
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

}
