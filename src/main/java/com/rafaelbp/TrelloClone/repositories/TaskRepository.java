package com.rafaelbp.TrelloClone.repositories;

import com.rafaelbp.TrelloClone.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
