package com.crudproject.taskmanager.Repository;

import com.crudproject.taskmanager.Model.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepository extends JpaRepository<TaskManager,Long> {

}
