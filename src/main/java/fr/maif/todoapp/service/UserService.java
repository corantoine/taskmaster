package fr.maif.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maif.todoapp.exception.NotFoundException;
import fr.maif.todoapp.messages.UserMessageDto;
import fr.maif.todoapp.models.UserEntity;
import fr.maif.todoapp.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Ici on utilise une List parce qu'on récupère une liste d'users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Integer userId) {
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            //            StringBuilder erreurMessage = new StringBuilder();
            //            erreurMessage.append("L'utilisateur ").append(userId).append(" n'existe pas.");
            //            throw new NotFoundException(erreurMessage.toString());
            String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
            throw new NotFoundException(erreurMessage);
        }
        return maybeUser.get();
    }

    public void deleteUserById(int userId) {
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isPresent()) {
            userRepository.deleteById(userId);
            return;
        }
        String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
        throw new NotFoundException(erreurMessage);
    }

    // creation de la methode updateUser
    public UserEntity updateUser(int userId, UserMessageDto userMessageDto) {
        // Chercher / trouver un user en bdd par son id:
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            String messageErreur = String.format("L'utilisateur %d n'existe pas", userId);
            throw new NotFoundException(messageErreur);
        }
        // recup du user lie a l'id : si un user est trouve, on le stocke dans variable:
        UserEntity userEntity = maybeUser.get();
        // mise a jour des differents parametres de l'user :
        userEntity.setUsername(userMessageDto.getUserName());
        userEntity.setEmail(userMessageDto.getEmail());
        userEntity.setFirstname(userMessageDto.getFirstname());
        userEntity.setLastname(userMessageDto.getLastname());
        userEntity.setCountry(userMessageDto.getCountry());
        // enregistre l'user modifie dans la bdd :
        userRepository.save(userEntity);
        // renvoi l'entité de l'user mise à jour en tant que réponse:
        return userEntity;
    }

}
