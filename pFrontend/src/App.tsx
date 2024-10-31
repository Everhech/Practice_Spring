import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

interface Character {
  id: number;
  name: string;
  status: string;
  species: string;
  type: string;
  gender: string;
  origin: object;
  location: object;
  image: string;
  episode: [""];
  created: string;
}

function App() {
  const [characters, setCharacters] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/api/getCharacters")
    .then((response) => {
      if(!response.ok){
        throw new Error("Error with fetching characters");
      }
      return response.json();
    })
    .then(data => setCharacters(data))
    .catch(error => console.error("There was an error fetching characters and get this error: " + error)); 
  }); 


  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card_container">
        {
          characters.map(character => {
            return (
              <div className="card" key={character?.id}>
                <div className='image'>
                  <img src={character?.image} alt="Character" />
                </div>
                <div className='information'>
                  <h2>Nombre: {character?.name}</h2>
                  <p>Estado: {character?.status}</p>
                  <p>Locacion: {character?.location?.name}</p>
                </div>
              </div>
            );
          })
        }
      </div>
    </>
  )
}

export default App
