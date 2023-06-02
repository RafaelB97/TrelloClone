package com.rafaelbp.TrelloClone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "list_id",
            foreignKey = @ForeignKey(name = "LIST_ID_FK")
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ListModel listModel;
}
