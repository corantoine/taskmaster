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

import fr.maif.todoapp.messages.TaskMessageDto;
import fr.maif.todoapp.models.TaskEntity;
import fr.maif.todoapp.service.TaskService;

@RestController
@RequestMapping("/taskmaster/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskEntity createNewTask(@RequestBody TaskMessageDto taskDTO) {
        return taskService.createNewTask(taskDTO);
    }

    @GetMapping
    //Ici on récupère toutes les tasks + toutes les infos associées
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{userId}")
    public List<TaskEntity> getAllTasksByUser(TaskMessageDto userTaskDto) {
        return taskService.getAllTasksByUser(userTaskDto);
    }

    @DeleteMapping(path = "/{taskId}")
    public void deleteTaskbyId(@PathVariable int taskId) {
        taskService.deleteTaskById(taskId);
    }

    //annotation qui gère les requetes http de type PUT pour les requêtes spécifiées:
    @PutMapping("/{taskId}")
    //Creation de la methode updateTask
    public TaskEntity updateTask(@PathVariable int taskId, @RequestBody TaskMessageDto taskMessageDto) {
        return taskService.updateTask(taskId, taskMessageDto);
    }
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