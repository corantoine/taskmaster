import React from 'react';
import {CreateUser} from '../services/users/CreateUser'
import { useNavigate } from "react-router-dom";
import '../styles/createUserForm.css'


const CreateUserForm = () => {
  const navigate = useNavigate();


  const handleSubmitRegister = 
    async (e) => {
      e.preventDefault();
  
      //récupérer les données du formulaire
      const { pseudo, prenom, nom, pays, email, password } = Object.fromEntries(
        new FormData(e.target)
      );

      //envoie dans l'api pour stocker les données dans notre BDD
      try{
        if(pseudo && prenom && nom && pays && email && password) {
         
            await CreateUser(pseudo, prenom, nom, pays, email, password);
            navigate("/");
         
        }
      } catch(error) {
        console.error(error.message);
      }
      }

   return (
   <div className="main-container">
     <div className="createUserForm-container">
       <h2>Créer un compte</h2>
       <form className="form-mini-container" onSubmit={handleSubmitRegister}>
         <div>
           <label htmlFor="pseudo">Pseudo :</label>
           <input type="text" id="pseudo" name="pseudo" />
         </div>
         <div>
            <label htmlFor="prenom">Prénom :</label>
             <input type="text" id="prenom" name="prenom" />
         </div>
            <div>
                     <label htmlFor="nom">Nom :</label>
                      <input type="text" id="nom" name="nom" />
                  </div>
                     <div>
                              <label htmlFor="pays">Pays :</label>
                               <input type="text" id="pays" name="pays" />
                           </div>
         <div>
           <label htmlFor="email">Email :</label>
           <input type="email" id="email" name="email" />
         </div>
         <div>
           <label htmlFor="password">Mot de passe :</label>
           <input type="password" id="password" name="password" autoComplete="on" />
         </div>
         <button type="submit">S'enregistrer</button>
       </form>
     </div>
     </div>
   );
 }

export default CreateUserForm;