package com.example.restfulapiproject.service;

import com.example.restfulapiproject.mapper.TaskMapper;
import com.example.restfulapiproject.model.dto.TaskDTO;
import com.example.restfulapiproject.model.entity.Task;
import com.example.restfulapiproject.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public TaskDTO getById(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO createOrUpdate(TaskDTO taskDTO) {
        Task task = mapper.toEntity(taskDTO);

        if (taskDTO.getId() == null) {
            task.setId(null);
        } else {
            Task existingTask = repository.findById(taskDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskDTO.getId()));

            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());

            task = existingTask;
        }

        Task savedTask = repository.save(task);

        return mapper.toDTO(savedTask);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
