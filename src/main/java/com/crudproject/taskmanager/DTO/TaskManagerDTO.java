package com.crudproject.taskmanager.DTO;

import com.crudproject.taskmanager.Enum.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;


@Data
public class TaskManagerDTO {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dueDate;


}
