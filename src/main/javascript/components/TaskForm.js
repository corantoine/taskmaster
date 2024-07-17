import { useState } from "react";

export default function TaskForm({handleAdd}){

// state
const [newTask, setNewTask] = useState("");

//comportements
  /****************Soumission du formulaire****************/
  const handleSubmit = (e) => {
    // Empêcher le rechargement de la page au moment de la soumission du form
    e.preventDefault();



    /************************** 2. Manipulation sur la copie du state **************************/
    // ici on défini l'id en fonction de la date; ainsi aucun item ne peut avoir 2 id identiques
    const id = new Date().getTime();
    // ici on attribue la valeur `newTask` à nom
    const nom = newTask;
    const taskToAdd = { id: id, nom: nom, taskCompleted: false }
    // ici on push le nouvel elem à la fin du tableau en lui attribuant un id et le nom saisi par l'utilisateur


    /************************** 3. Modifier le state avec le setter **************************/
    // setNewTask prend en compte l'input texte, donc on réinitialise son état à vide pour "vider" l'input
    handleAdd(taskToAdd)
    setNewTask("");
  }

  /****************** Ajout d'une nouvelle tache *****************/
  //Un événement onChange est déclenché lorsque des valeurs sont saisies dans l’entrée. 
  //Cela déclenche une fonction handleChange() , qui est utilisée pour définir un nouvel état pour l’entrée.
  const handleChange = (e) => {
    // const valueAfterChange = e.target.value;
    setNewTask(e.target.value);
  }

//render
    return(
      <div className="inputAndButton">
        <form action="submit" onSubmit={handleSubmit}>
        <input className="input" 
          value={newTask}
          type="text"
          placeholder="Ajoutez une tache..."
          onChange={handleChange} />
        <button className="button">Ajouter</button>
      </form>
      </div>)
}