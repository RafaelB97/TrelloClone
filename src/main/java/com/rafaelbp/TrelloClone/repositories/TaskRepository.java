package com.rafaelbp.TrelloClone.repositories;

import com.rafaelbp.TrelloClone.models.Task;
import com.rafaelbp.TrelloClone.models.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByListModel(ListModel list);
    public Optional<Task> findByIdAndListModel(Long id, ListModel list);
}
