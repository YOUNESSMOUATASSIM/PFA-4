import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import axios from "axios"

axios.defaults.baseURL = "http://localhost:8082/"
// axios.defaults.headers.common["authorization"] = 

ReactDOM.render(<App />,
  document.getElementById('root')
);
