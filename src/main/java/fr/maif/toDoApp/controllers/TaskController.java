package fr.maif.toDoApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maif.toDoApp.models.TaskEntity;
import fr.maif.toDoApp.models.UserEntity;
import fr.maif.toDoApp.repositories.TaskRepository;
import fr.maif.toDoApp.repositories.UserRepository;
import messages.TaskMessageDto;

@RestController
@RequestMapping("/taskmaster/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public TaskEntity createNewTask(@RequestBody TaskMessageDto taskDTO) {
        TaskEntity newTask = new TaskEntity(); // Crée une instance de task
        newTask.setTaskName(taskDTO.getTaskName());
        Optional<UserEntity> maybeUser = userRepository.findById(taskDTO.getUserId());
        if (maybeUser.isEmpty()) { //TODO erreur 400 BAD REQUEST
            throw new RuntimeException("L'utilisateur " + taskDTO.getUserId() + " n'existe pas");
        }
        UserEntity user = maybeUser.get();
        newTask.setUser(user);
        return taskRepository.save(newTask);
    }

    @GetMapping
    //Ici on récupère toutes les tasks + toutes les infos associées
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<TaskEntity> getAllTasksByUser(TaskMessageDto userTaskDto) {
        return taskRepository.findTaskByUserId(userTaskDto.getUserId());
    }

    @DeleteMapping("/{taskId}")
    //TODO : gestion d'erreur si la tache n'existe pas
    public void deleteTaskbyId(@PathVariable int taskId) {
        taskRepository.deleteById(taskId);
    }

    //annotation qui gère les requetes http de type PUT pour les requêtes spécifiées:
    //    @PutMapping({"/taskId"})
    //    //Creation de la methode updateTask :
    //    public TaskEntity updateTask(@PathVariable int taskId, @RequestBody TaskMessageDto taskMessageDto) {
    //        //Chercher / trouver une tache en bdd par son id:
    //        Optional<TaskEntity> maybetask = taskRepository.findById(taskId);
    //        //}
    //        //recup de la task liee a l'id : si une task est trouve, on la stocke dans variable:
    //        TaskEntity taskEntity = maybetask.get();
    //        //maj des differents params de la task :
    //        taskEntity.setDueDate(taskMessageDto.getDueDate());
    //        taskEntity.setTaskName(taskMessageDto.getTaskName());
    //        //enregistre la task modifie dans la bdd :
    //        taskRepository.save(taskEntity);
    //        //renvoi l'entité de task màj en tant que réponse:
    //        return taskEntity;
    //    }

    //annotation qui gère les requetes http de type PUT pour les requêtes spécifiées:
    @PutMapping("/{taskId}")
    //Creation de la methode updateTask
    public TaskEntity updateTask(@PathVariable int taskId, @RequestBody TaskMessageDto taskMessageDto) {
        //Chercher / trouver une task en bdd par son id:
        Optional<TaskEntity> maybeTask = taskRepository.findById(taskId);
        //    if (maybeTask.isEmpty()) {
        //        // ex : concaténation de chaine "naive" : fonctionne mais pas bonne pratique
        //        //            throw new NotFoundException("La tache " + taskId + " recherchée n'existe pas");
        //        //concatenation avec stringBuilder mais plutot qd il y a bcp de choses
        //        //            StringBuilder stringBuilder = new StringBuilder();
        //        //            stringBuilder.append("La tache ").append(taskId).append(" recherchee n'existe pas.");
        //        //            String messageErreur = stringBuilder.toString();
        //        //Methode statique de String + adapté pour petits messages
        //        String messageErreur = String.format("La tache %d recherchee n'existe pas", taskId);
        //        throw new NotFoundException(messageErreur);
        //    }
        //recup de la tache liee a l'id : si une tache est trouvee, on la stocke dans variable:
        TaskEntity taskEntity = maybeTask.get();
        //mise a jour des differents parametres de la task :
        taskEntity.setDueDate(taskMessageDto.getDueDate());
        taskEntity.setTaskName(taskMessageDto.getTaskName());
        //enregistre la task modifiee dans la bdd :
        taskRepository.save(taskEntity);
        //renvoi l'entité de tache mise à jour en tant que réponse
        return taskEntity;
    }
}