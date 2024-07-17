//FIXME : pourquoi export ?
export async function createTask(nom, dueDate, taskCompleted) {
  // Creer une variable avec l'URL cible
  const url = "http://localhost:8080/tasks";
  // Request : interface de l'API Fetch représentant une demande de ressource
  const myRequest = new Request(url);

  /* Options pour la requête (par exemple, le corps de la requête)
   dans cette variable on définit la méthode utilisée et le contenu 
   envoyé et qu'on attend en réponse */
  const option = {
    //Type de la méthode
    method: "POST",
    //Contenu envoyé et  ?
    headers: {
      "Content-Type": "application/json",
      "Accept": "application/json",
    },
    body: JSON.stringify({
      //dénominations back/front pour faire la correspondance des données
      taskName: nom,
      dueDate: dueDate,
      completionState: taskCompleted
    })
  };

  //gestion d'erreur try... catch
  try {
    const response = await fetch(myRequest, option);
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`)
    }

    alert('User created successfully!');

  } catch (error) {
    // console.error("Erreur de récupération des données :", error.message);
    alert('User creation aborted!');
    throw error;
  }

}