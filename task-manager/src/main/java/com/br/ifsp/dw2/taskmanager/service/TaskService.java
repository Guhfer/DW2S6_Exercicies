package com.br.ifsp.dw2.taskmanager.service;

import com.br.ifsp.dw2.taskmanager.controller.resource.TaskResource;
import com.br.ifsp.dw2.taskmanager.entity.Tag;
import com.br.ifsp.dw2.taskmanager.entity.Task;
import com.br.ifsp.dw2.taskmanager.entity.User;
import com.br.ifsp.dw2.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TagService tagService;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService userService, TagService tagService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.tagService = tagService;
    }

    public TaskResource saveTask(TaskResource taskResource) {

        return buildTaskResource(taskRepository.save(buildTask(taskResource,
                userService.findById(taskResource.getUser()),
                tagService.findById(taskResource.getTag()))));
    }

    public TaskResource findTaskById(Long id) {
        return buildTaskResource(taskRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Task not found")));
    }

    public List<TaskResource> findAll() {
        return taskRepository.findAll()
                .stream().map(this::buildTaskResource).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        findTaskById(id);
        taskRepository.deleteById(id);
    }

    private TaskResource buildTaskResource(Task task) {
        return new TaskResource(task);
    }

    private Task buildTask (TaskResource taskResource, User user, Tag tag) {
        return new Task(taskResource.getDescription(), taskResource.getDate(), taskResource.getNote(), user, tag);
    }
}
