package fr.maif.todoapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maif.todoapp.messages.UserMessageDto;
import fr.maif.todoapp.models.UserEntity;
import fr.maif.todoapp.service.UserService;

@RestController
@RequestMapping("/taskmaster/users")
public class UserController {

    @Autowired
    private UserService userService;

    //    public UserController(UserRepository userRepository) {
    //        this.userRepository = userRepository;
    //    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        userService.deleteUserById(userId);
    }

    // annotation qui gère les requetes http de type PUT pour les requêtes
    // spécifiées:
    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable int userId, @RequestBody UserMessageDto userMessageDto) {
        return userService.updateUser(userId, userMessageDto);
    }
}

//TODO 1 - annotation qui gère les requetes http de type PUT pour les requêtes spécifiées:

//TODO 2 - Creation de la methode updateUser :

//TODO 3 - Chercher / trouver un user en bdd par son id:

//TODO 4 - recup du user lie a l'id : si un user est trouve, on le stocke dans variable:

//TODO 5 - mise a jour des differents parametres de l'user :

//TODO 6 - enregistre l'user modifie dans la bdd :

//TODO 7 - renvoi l'entité de l'user mise à jour en tant que réponse:

// }