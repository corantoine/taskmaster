package fr.maif.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maif.todoapp.exception.NotFoundException;
import fr.maif.todoapp.messages.TaskMessageDto;
import fr.maif.todoapp.models.TaskEntity;
import fr.maif.todoapp.models.UserEntity;
import fr.maif.todoapp.repositories.TaskRepository;
import fr.maif.todoapp.repositories.UserRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskEntity createNewTask(TaskMessageDto taskDTO) {
        TaskEntity newTask = new TaskEntity(); // Crée une instance de task
        newTask.setTaskName(taskDTO.getTaskName());
        Optional<UserEntity> maybeUser = userRepository.findById(taskDTO.getUserId());
        if (maybeUser.isEmpty()) {
            throw new RuntimeException("L'utilisateur " + taskDTO.getUserId() + " n'existe pas");
        }
        UserEntity user = maybeUser.get();
        newTask.setUser(user);
        return taskRepository.save(newTask);
    }

    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> getAllTasksByUser(TaskMessageDto userTaskDto) {
        return taskRepository.findTaskByUserId(userTaskDto.getUserId());
    }

    //TODO : gestion d'erreur si la tache n'existe pas
    public void deleteTaskById(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskEntity updateTask(int taskId, TaskMessageDto taskMessageDto) {
        Optional<TaskEntity> maybeTask = taskRepository.findById(taskId);
        if (maybeTask.isEmpty()) {
            String messageErreur = String.format("La tache %d recherchee n'existe pas", taskId);
            throw new NotFoundException(messageErreur);
        }
        TaskEntity taskEntity = maybeTask.get();
        taskEntity.setDueDate(taskMessageDto.getDueDate());
        taskEntity.setTaskName(taskMessageDto.getTaskName());
        taskRepository.save(taskEntity);
        return taskEntity;
    }

}

//
//        if (maybeTask.isEmpty()) {
//        // ex : concaténation de chaine "naive" : fonctionne mais pas bonne pratique
//        //            throw new NotFoundException("La tache " + taskId + " recherchée n'existe pas");
//        //concatenation avec stringBuilder mais plutot qd il y a bcp de choses
//        //            StringBuilder stringBuilder = new StringBuilder();
//        //            stringBuilder.append("La tache ").append(taskId).append(" recherchee n'existe pas.");
//        //            String messageErreur = stringBuilder.toString();
//        //Methode statique de String + adapté pour petits messages
//        String messageErreur = String.format("La tache %d recherchee n'existe pas", taskId);
//        throw new NotFoundException(messageErreur);