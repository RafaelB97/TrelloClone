package com.rafaelbp.TrelloClone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Boolean finish;
    private String date;
    @ManyToOne
    @JoinColumn(
            name = "list_id",
            foreignKey = @ForeignKey(name = "LIST_ID_FK")
    )
    private ListModel listModel;
}
