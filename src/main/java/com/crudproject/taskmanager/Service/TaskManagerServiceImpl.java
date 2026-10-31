package com.crudproject.taskmanager.Service;

import com.crudproject.taskmanager.DTO.TaskManagerDTO;
import com.crudproject.taskmanager.Enum.Status;
import com.crudproject.taskmanager.Model.TaskManager;
import com.crudproject.taskmanager.Repository.TaskManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{

    public final TaskManagerRepository taskManagerRepository;

    public TaskManagerServiceImpl(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }


    @Override
    public List<TaskManagerDTO> getAllTasks() {

        return taskManagerRepository.findAll()
                .stream()
                .map(task -> {
                    TaskManagerDTO dto = new TaskManagerDTO();

                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    dto.setDueDate(task.getDueDate());
                    dto.setStatus(task.getStatus());

                    return dto;
                })
                .toList();
    }

    @Override
    public TaskManagerDTO addTask(TaskManagerDTO dto) {



            TaskManager task = new TaskManager();

            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setDueDate(dto.getDueDate());
            task.setStatus(dto.getStatus());

            TaskManager savedTask = taskManagerRepository.save(task);

            TaskManagerDTO response = new TaskManagerDTO();


            response.setTitle(savedTask.getTitle());
            response.setDescription(savedTask.getDescription());
            response.setDueDate(savedTask.getDueDate());
            response.setStatus(savedTask.getStatus());

            return response;

    }

    @Override
    public Optional<TaskManagerDTO> getTaskById(Long id) {

        return taskManagerRepository.findById(id)
                .map(task -> {

                    TaskManagerDTO dto = new TaskManagerDTO();

                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    dto.setDueDate(task.getDueDate());
                    dto.setStatus(task.getStatus());

                    return dto;
                });
    }


    @Override
    public Optional<TaskManagerDTO> updateTask(Long id, TaskManagerDTO dto) {
        TaskManager task = taskManagerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(dto.getStatus());


        TaskManager savedTask = taskManagerRepository.save(task);

        TaskManagerDTO response = new TaskManagerDTO();

        response.setTitle(savedTask.getTitle());
        response.setDescription(savedTask.getDescription());
        response.setDueDate(savedTask.getDueDate());
        response.setStatus(savedTask.getStatus());

        return Optional.of(response);


    }

    @Override
    public void deleteTask(Long id) {
        taskManagerRepository.deleteById(id);
    }

    @Override
    public TaskManagerDTO changeStatus(Long id, Status status) {

        TaskManager task = taskManagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);

        TaskManager updatedTask = taskManagerRepository.save(task);

        TaskManagerDTO dto = new TaskManagerDTO();
        dto.setTitle(updatedTask.getTitle());
        dto.setDescription(updatedTask.getDescription());
        dto.setDueDate(updatedTask.getDueDate());
        dto.setStatus(updatedTask.getStatus());

        return dto;
    }
}
