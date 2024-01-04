package com.example.restfulapiproject.facade;

import com.example.restfulapiproject.mapper.TaskMapper;
import com.example.restfulapiproject.model.dto.TaskDTO;
import com.example.restfulapiproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskFacadeImpl implements TaskFacade {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @Override
    public TaskDTO getById(Long id) {
        return taskService.getById(id);
    }

    @Override
    public TaskDTO createOrUpdate(TaskDTO taskDTO) {
        return taskService.createOrUpdate(taskDTO);
    }

    @Override
    public void deleteById(Long id) {
        taskService.deleteById(id);
    }
}
