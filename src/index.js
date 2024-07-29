import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './main/javascript/App.js';
import Header from '../src/main/javascript/components/Header';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
       <Header />
    <App />
  </React.StrictMode>
);
