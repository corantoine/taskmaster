// export default function Taches(props) {
// const taskInfo = props.taskInfo;
// const onTaskDelete = props.onTaskDelete;
// const onTaskCheck = props.onTaskCheck;
// Peut aussi s'écrire comme ça (destructuring): 
// const {taskInfo, onTaskCheck, onTaskDelete} = props
// passer props en params de la fonction revient au même que de faire le destructuring directement en params de la fonction

const UpdateTask = ({ taskInfo, onTaskDelete, onCheck }) => {
    //méthode aaaaa
    // Si je suis en édition, je retourne un noeud react en particulier
    // Sinon, je retourne le composant Task

    const { taskCompleted: completed, nom, date, id } = taskInfo


    // l'input type="date" me renvoyait la date au format aaaa-mm-jj, je veux le format jj/mm/aaaa
   // Convertir la date au format "jj/mm/aaaa" : 
   // Puis j'utilise la méthode .padStart() afin de compléter la chaîne courante avec une chaîne de caractères donnée afin d'obtenir une chaîne de longueur fixée
   // J'utilise également .toString() car la méthode .padStart() ne fonctionne que sur les string
   const formattedDate = new Date(date);
   const day = formattedDate.getDate().toString().padStart(2, '0'); // Ajoute un zéro devant le jour si nécessaire
   const month = (formattedDate.getMonth() + 1).toString().padStart(2, '0'); // Ajoute un zéro devant le mois si nécessaire
   const year = formattedDate.getFullYear();
   const formattedDateString = `${day}/${month}/${year}`;

    return (
        <li
            className=
            {completed ? "completed-task" : "uncomplete-task"}
        >
            <p className="showName">Tâche :<br></br>{nom}</p> 
            <p className="showDate">Deadline :<br></br> {formattedDateString}</p>
            <input
                className="checkbox"
                type="checkbox"
                onChange={() => onCheck(id)}
                checked={completed}
            />

            <button
                // disabled={!completed}
                className="deleteButton"
                onClick={() => onTaskDelete(id)}>Supprimer</button>
        </li>
    )
}

export default UpdateTask;
