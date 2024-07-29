import { baseApi } from '../apiConfig'

//Creation de la fonction async createUser()
export async function CreateUser(pseudo, prenom, nom, pays, email, password) {

    const userURL = new URL("http://localhost:8080/taskmaster/users")
    // const userURL =("http://localhost:8080/taskmaster/users")

    // Créer un objet contenant les options de requete (requete + reponse)
    const option = {
        //Type de la méthode
        method: 'POST',
        //Contenu envoyé et  ?
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({
            //dénominations back/front pour faire la correspondance des données
            username: pseudo,
            firstname: prenom,
            lastname: nom,
            country: pays,
            email: email,
            password: password
        })
    }
    // gestion d'erreur try...catch
    try {
        const reponse = await fetch(userURL, option);
        console.log(reponse);
        if (!reponse.ok) {
            throw new Error(`HTTP error! Status: ${reponse.status}`)
        }
        alert('User created successfully !');
    } catch (error) {
        alert("User creation aborted !");
        throw error;
    }
};


