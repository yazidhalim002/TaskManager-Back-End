package com.crudproject.taskmanager.Service;

import com.crudproject.taskmanager.DTO.TaskManagerDTO;
import com.crudproject.taskmanager.Enum.Status;
import com.crudproject.taskmanager.Model.TaskManager;

import java.util.List;
import java.util.Optional;

public interface TaskManagerService {

    List<TaskManagerDTO> getAllTasks();

    TaskManagerDTO addTask(TaskManagerDTO dto);

    Optional<TaskManagerDTO> getTaskById(Long id);

    Optional<TaskManagerDTO> updateTask(Long id, TaskManagerDTO dto);

    void deleteTask(Long id);

    TaskManagerDTO changeStatus(Long id, Status status);
}
