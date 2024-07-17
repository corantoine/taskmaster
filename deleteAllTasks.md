  Supprime toutes les tâches d'un coup :
  
 ```js // ici on passe l'id en paramètre de la fonction
  const handleDelete = (id) => {
    console.log('Supprimer')

    const taskCopy = [...tasks];

    // ici on veut filtrer par id pour supprimer la tâche selectionnée
    // On garde toutes les tâches dont l'id est différent de celui sélectionné    
    // L'effet n'est pas l'effet attendu, supprime toutes les tâches au lieu de supprimer la tâche cible
    
    const deleteTask = taskCopy.filter(task => task.id !== task.id)
    setTasks(deleteTask)
  }
  ```