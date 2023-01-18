package com.rafaelbp.TrelloClone.repositories;

import com.rafaelbp.TrelloClone.models.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListModel, Long> {
}
