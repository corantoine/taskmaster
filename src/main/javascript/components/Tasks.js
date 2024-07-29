import { useState } from "react";
import "../styles/tasks.css"
import Task from "./UpdateTask"
import TaskForm from "./TaskForm";


function Tasks() {
  // state
  const [tasks, setTasks] = useState([
    // { id: 1, nom: "Marquer une tâche comme étant terminée, en utilisant la souris ou le clavier", taskCompleted: false },
    // { id: 2, nom: "Modifier n'importe quelle tâche, en utilisant la souris ou le clavier.", taskCompleted: false },
    // { id: 3, nom: "Afficher un sous-ensemble spécifique de tâches :", taskCompleted: false },
    // { id: 4, nom: "Toutes les tâches", taskCompleted: false },
    // { id: 5, nom: "Seulement la tâche active", taskCompleted: false },
    // { id: 6, nom: "Seulement les tâches terminées.", taskCompleted: false },
  ])

  // const [taskCompleted, setTaskCompleted] = useState(false);

  // comportement
  const handleDelete = (id) => {
    // ici on passe l'id en paramètre de la fonction
    const taskCopy = [...tasks];

    // ici on veut filtrer par id pour supprimer la tâche selectionnée
    // On garde toutes les tâches dont l'id est différent de celui sélectionné    
    const taskCopyUpdated = taskCopy.filter(task => task.id !== id)
    setTasks(taskCopyUpdated)

  }

  // Au clic dans la checkbox, je veux que mon texte soit barré.
  // Nécessite une classe pour fonctionner
  const handleCheck = (id) => {

    /************************** 1. Copie du state **************************/
    //Ici on crée une copie du tableau tasks
    var tasksCopy = [...tasks];

    // /************************** 2. Manipulation sur la copie du state **************************/
    //Ici on recherche la tâche correspondant à l'id fourni
    var taskCopyUpdated = tasksCopy.find(task => task.id === id)
    // On met à jour taskCopyUpdated afin d'inverser la valeur de la propriété taskCompleted
    taskCopyUpdated = { ...taskCopyUpdated, taskCompleted: !taskCopyUpdated.taskCompleted }


    //Ici on cherche l'index de la tâche correspondant à l'id
    const findTask = tasksCopy.findIndex(task => task.id === id)

    // Ici on remplace la tâche à l'index findTask par la tâche maj (taskCopyUpdated)
    tasksCopy.splice(findTask, 1, taskCopyUpdated)



    //Ici on filtre les valeurs pour ne garder que les valeurs qui remplissent la condition
    // const tasksWithoutOldValue = tasksCopy.filter(task => task.id !== id)
    // Spread operator fonctionne aussi MAIS il pousse la nouvelle valeur à la fin du tableau
    // tasksCopy = [...tasksWithoutOldValue, taskCopyUpdated]  

    // trouver et maj task dans le tableau
    /************************** 3. Modifier le state avec le setter **************************/
    setTasks(tasksCopy)
  }

  const handleAdd = (taskToAdd) => {
    //1. Copie du state 
    // copie du tableau task avec le spread operator
    const taskCopy = [...tasks];
    //2. Manipulation sur la copie du state 
    taskCopy.push(taskToAdd);
    //3. Modifier le state avec le setter
    // ici on modifie le state pour afficher l'ajout d'élément
    setTasks(taskCopy);
  }

  // render
  return (
    <div className="task-container">
      <h2> Tâches à faire : </h2>
      <ul>
        {tasks.map((task) => (
          <Task taskInfo={task}
            onTaskDelete={handleDelete}
            onCheck={handleCheck}
            key={task.id}
          />
        ))}
      </ul>
      <span className="form-container">
        <TaskForm handleAdd={handleAdd} />
      </span>
      <h2> Tâches terminées : </h2>
    </div>
  )
}


export default Tasks;
