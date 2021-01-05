package com.br.ifsp.dw2.taskmanager.repository;

import com.br.ifsp.dw2.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
