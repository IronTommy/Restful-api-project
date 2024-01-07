package com.example.restfulapiproject.controller;

import com.example.restfulapiproject.facade.TaskFacade;
import com.example.restfulapiproject.model.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskFacade taskFacade;

    public TaskController(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return taskFacade.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createOrUpdate(@RequestBody TaskDTO taskDTO) {
        return taskFacade.createOrUpdate(taskDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        taskFacade.deleteById(id);
    }

}
