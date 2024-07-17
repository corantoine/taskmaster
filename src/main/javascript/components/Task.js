// export default function Taches(props) {
// const taskInfo = props.taskInfo;
// const onTaskDelete = props.onTaskDelete;
// const onTaskCheck = props.onTaskCheck;
// Peut aussi s'écrire comme ça (destructuring): 
// const {taskInfo, onTaskCheck, onTaskDelete} = props
// passer props en params de la fonction revient au même que de faire le destructuring directement en params de la fonction

const Task = ({ taskInfo, onTaskDelete, onCheck }) => {
//méthode aaaaa
// Si je suis en édition, je retourne un noeud react en particulier
// Sinon, je retourne le composant Task

const {taskCompleted: completed, nom, id} = taskInfo

    return (
        <li
            className=
            {completed ? "completed-task" : "uncomplete-task"}
        >
            {nom}
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

export default Task;
