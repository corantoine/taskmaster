package fr.maif.todoapp.controllers;

import java.security.InvalidKeyException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.maif.todoapp.messages.UserMessageDto;

@RestController
public class AuthenticationController {

    @PostMapping("/taskmaster/login")

    public String login(@RequestBody UserMessageDto request) throws InvalidKeyException {
        // Ici on vérifie les infos d'identification :
        if (isValidCredentials(request.getUserName(), request.getPassword())) {
            //generation jwt
            String jwt = generateJwt(request.getUserName());
            return jwt;
        } else {
            throw new InvalidKeyException("Erreur lors de l'authentification");
        }

    }

    private boolean isValidCredentials(String username, String password) {
        //logique de code à implémenter
    }

    private String generateJwt(String username) {
        //logique de code à implémenter
        return;
    }

}
