package com.rafaelbp.TrelloClone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LIST")
public class ListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @OneToMany(
            mappedBy = "listModel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
        task.setListModel(this);
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
        task.setListModel(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListModel )) return false;
        return id != null && id.equals(((ListModel) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
