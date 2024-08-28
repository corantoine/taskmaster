import { baseApi } from '../apiConfig';



export async function createTask(nom, dueDate, taskCompleted) {

  const taskURL = new URL(baseApi, "/tasks")

  /* Options pour la requête (par exemple, le corps de la requête)
   dans cette variable on défini la méthode utilisée et le contenu
   envoyé et qu'on attend en réponse */
  const option = {
    //Type de la méthode
    method: "POST",
    //Informations sur les données envoyées et attendues en retour
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
    const response = await fetch(taskURL, option);
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`)
    }
    alert('Task created successfully!');
  } catch (error) {
    // console.error("Erreur de récupération des données :", error.message);
    alert('Task creation aborted!');
    throw error;
  }

}