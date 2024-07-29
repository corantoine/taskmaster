package fr.maif.todoapp.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "tasks")

public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Clé étrangère
    //  Qd on récup une tâche on récupère l'user
    // On ne peut pas récupérer de valeur nulle
    @ManyToOne(
            optional = false,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "user_id", nullable = false)
    //approach to solve JSON recursive dependency
    //permet d'afficher les tasks et leurs users(et inversement) sans créer de boucle infinie
    @JsonIgnoreProperties("tasks")
    private UserEntity user;

    @NonNull
    @Column(name = "task_name")
    private String taskName;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "completion_state")
    private boolean completionState;

    public TaskEntity() {
    }

}

