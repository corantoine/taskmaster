import { useState } from "react";
// import { createTask } from "../services/tasks/CreateTask"


export default function TaskForm({ handleAdd }) {

  // state
  const [newTaskName, setNewTaskName] = useState("");
  const [selectedDate, setSelectedDate] = useState(""); // Ajoutez un état pour stocker la date sélectionnée

  //comportements
  /****************Soumission du formulaire****************/
  const handleSubmit = (e) => {
    // Empêcher le rechargement de la page au moment de la soumission du form
    e.preventDefault();



    /************************** 2. Manipulation sur la copie du state **************************/
    // ici on défini l'id en fonction de la date; ainsi aucun item ne peut avoir 2 id identiques
    const id = new Date().getTime();
    // ici on attribue la valeur `newTaskName` à nom
    const nom = newTaskName;
    const date = selectedDate;
    const taskToAdd = { id: id, nom: nom, date: date, taskCompleted: false }
    // ici on push le nouvel elem à la fin du tableau en lui attribuant un id et le nom saisi par l'utilisateur

    //
    // createTask(nom, new Date(), false)


    /************************** 3. Modifier le state avec le setter **************************/
    // setNewTaskName prend en compte l'input texte, donc on réinitialise son état à vide pour "vider" l'input
    handleAdd(taskToAdd)
    setNewTaskName("");
    setSelectedDate(""); // Réinitialisez la date sélectionnée après l'ajout de la tâche

  }




  const handleDateChange = (e) => {
    setSelectedDate(e.target.value); // Met à jour l'état de la date sélectionnée
  };

  /****************** Ajout d'une nouvelle tache *****************/
  //Un événement onChange est déclenché lorsque des valeurs sont saisies dans l’entrée. 
  //Cela déclenche une fonction handleChange() , qui est utilisée pour définir un nouvel état pour l’entrée.
  const handleChange = (e) => {
    // const valueAfterChange = e.target.value;
    setNewTaskName(e.target.value);
  }

  //render
  return (
    <div className="inputAndButton">
      <form action="submit" onSubmit={handleSubmit}>
        <input className="input"
          value={newTaskName}
          type="text"
          placeholder="Ajoutez une tache..."
          onChange={handleChange} />
        <input
          type="date"
          value={selectedDate} // Utilisez la date sélectionnée ici
          onChange={(e) => handleDateChange(e)} // Gérez le changement de date
        />
        <button className="button">Ajouter</button>
      </form>
    </div>)
}