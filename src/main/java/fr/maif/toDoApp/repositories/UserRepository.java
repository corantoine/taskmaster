package fr.maif.toDoApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.maif.toDoApp.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //    Optional<User> findByUsernameAndPassword(String username, String password);

    //FIXME may be deleted
    public Optional<UserEntity> getByUsername(String userName);
}
