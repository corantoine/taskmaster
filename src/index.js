import React from 'react';
import ReactDOM from 'react-dom/client';
import App from '../src/main/javascript/App.js';
import Header from '../src/main/javascript/components/Header';
import LoginForm from './main/javascript/components/LoginForm.js';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Header />
    <BrowserRouter>
    <Routes>
    <Route path='/' element={<LoginForm />}/>
    <Route path = 'tasks' element= {<App />} />
    </Routes> 
    </BrowserRouter>
    
  </React.StrictMode>
);
