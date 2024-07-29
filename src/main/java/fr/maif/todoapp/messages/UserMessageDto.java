package fr.maif.todoapp.messages;

import lombok.Data;

@Data
public class UserMessageDto {
    private int userId;
    private String userName;
    private String email;
    private String firstname;
    private String lastname;
    private String country;

}
