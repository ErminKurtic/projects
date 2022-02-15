import React, { Component, useEffect, useState } from "react";
import axios from "axios";
import PokemonCard from "./PokemonCard";
import "../../App.css";


const PokemonList = () => {
    const [pokemons, setPokemons] = useState([]);

    useEffect(() => {
      const getPokemons = async () => {
        const result = await axios.get('https://pokeapi.co/api/v2/pokemon?limit=100');
        setPokemons(result.data['results']);
      }
      getPokemons();
    }, [])

    return (
        <React.Fragment>
            {pokemons.length ? (
                <div className="row">
                    {pokemons.map((pokemon, index) => (
                        <PokemonCard
                            key={pokemon.name}
                            index={index + 1}
                            name={pokemon.name}
                        />
                    ))}
                </div>
            ) : (
                <div id="loading" style={{
                    paddingTop: '40rem',
                    paddingLeft: '6rem'
                }}>
                    <div className="pokeball" id="normal"></div>
                </div>
            )}
        </React.Fragment>
    );
}

export default PokemonList;
