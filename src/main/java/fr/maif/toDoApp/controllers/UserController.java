package fr.maif.toDoApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maif.toDoApp.exception.NotFoundException;
import fr.maif.toDoApp.models.UserEntity;
import fr.maif.toDoApp.repositories.UserRepository;
import messages.UserMessageDto;

@RestController
@RequestMapping("/taskmaster/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour créer un user en base de données
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping
    // Ici on utilise une List parce qu'on récupère une liste d'users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Integer userId) {
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            // StringBuilder erreurMessage = new StringBuilder();
            // erreurMessage.append("L'utilisateur ").append(userId).append(" n'existe
            // pas.");
            // throw new NotFoundException(erreurMessage.toString());
            String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
            throw new NotFoundException(erreurMessage);
        }
        return maybeUser.get();
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        Optional<UserEntity> maybeUser = userRepository.findById(userId);
        if (maybeUser.isPresent()) {
            userRepository.deleteById(userId);
            return;
        }
        String erreurMessage = String.format("L'utilisateur %d n'existe pas", userId);
        throw new NotFoundException(erreurMessage);
    }

    // //annotation qui gère les requetes http de type PUT pour les requêtes
    // spécifiées:
    // @PutMapping("/{userId}")
    // //Creation de la methode updateUser :
    // public UserEntity updateUser(@PathVariable int userId, @RequestBody
    // UserMessageDto userMessageDto) {
    // //Chercher / trouver un user en bdd par son id:
    // Optional<UserEntity> maybeUser = userRepository.findById(userId);
    // //}
    // //recup du user lie a l'id : si un user est trouve, on le stocke dans
    // variable:
    // UserEntity userEntity = maybeUser.get();
    // //mise a jour des differents parametres de l'user :
    // userEntity.setFirstname(userMessageDto.getFirstname());
    // userEntity.setLastname(userMessageDto.getLastname());
    // userEntity.setCountry(userMessageDto.getCountry());
    // userEntity.setEmail(userMessageDto.getEmail());
    // userEntity.setUsername(userMessageDto.getUserName());
    // //enregistre l'user modifie dans la bdd :
    // userRepository.save(userEntity);
    // //renvoi l'entité de l'user mise à jour en tant que réponse:
    // return userEntity;
    // }

    // annotation qui gère les requetes http de type PUT pour les requêtes
    // spécifiées:
    @PutMapping("/{userId}")
    // Creation de la methode updateUser :
    public UserEntity updateUser(@PathVariable int userId, @RequestBody UserMessageDto userMessageDto) {
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