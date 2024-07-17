package fr.maif.toDoApp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String username;
    private String firstname;
    private String lastname;
    private String country;
    private String email;

    @JsonIgnore
    //    @NonNull FIXME a revoir pour authentification
    private String password;

    //Pourquoi utilser mappedBy

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    //Ici il faut utiliser mappedBy et non JoinColumn :
    // user est "propriétaire" de la relation à revoir!
    //@JoinColumn(name = "id")
    //    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("user")
    private List<TaskEntity> tasks;

    public UserEntity() {
    }

    //    // Constructeur pour faire des copies d'objet
    //    public User(User user) {
    //        //
    //        this.username = user.getUsername();
    //    }

}
