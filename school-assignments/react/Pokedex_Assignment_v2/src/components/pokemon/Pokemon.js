import axios from "axios";
import React, { Component, useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";

const Pokemon = () => {
    const [pokemon, setPokemon] = useState();
    const { pokemonIndex } = useParams();

    const getPokemonStat = (stats) => (name) => stats.find(x => x.stat.name === name)['base_stat'];
    const createPokemon = (pokemon) => {

        const height = Math.round((pokemon.height * 0.328084 + 0.0001) * 100) / 100;
        const weight = Math.round((pokemon.weight * 0.220462 + 0.0001) * 100) / 100;
        const types = pokemon.types.map((type) => type.type.name);

        const pokemonStat = getPokemonStat(pokemon.stats);
        // Create my pokemon object for this component
        const myNewShinyObject = {
            name: pokemon.name,
            pokemonIndex: pokemonIndex,
            imageUrl: pokemon.sprites.front_default,
            types,
            height,
            weight,
            stats: {
                hp: pokemonStat('hp'),
                attack: pokemonStat('attack'),
                defense: pokemonStat('defense'),
                speed: pokemonStat('speed'),
                specialAttack: pokemonStat('special-attack'),
                specialDefense: pokemonStat('special-defense'),
            }

        }
        setPokemon(myNewShinyObject);
    }

    useEffect(() => {
        const getPokemon = async () => {
            //URL for Pokemon Information
            const pokemonUrl = `https://pokeapi.co/api/v2/pokemon/${pokemonIndex}/`;
            const result = await axios.get(pokemonUrl);
            createPokemon(result.data);
        }

        getPokemon();
    }, [])

    if(!pokemon) {
        return <>Loading..</>
    }

        return (
            <div className="col">
                <div className="card">
                    <div className="card-header">
                        <div className="row">
                            <div className="col-5">
                                <h5>{pokemon.pokemonIndex}</h5>
                            </div>
                            <div className="col-7">
                                <div className="float-right">
                                    {pokemon.types.map((type) => (
                                        <span
                                            key={type}
                                            className="badge badge-pill mr-1"
                                        >
                                            {type}
                                        </span>
                                    ))}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="card-body">
                        <div className="row align-items center">
                            <div className="col-md-3">
                                <img
                                    src={pokemon.imageUrl}
                                    className="card-img-top rounded mx-auto mt-2"
                                />
                            </div>
                            <div className="col-md-9">
                                <h4 className="mx-auto">
                                    {pokemon.name
                                        .toLowerCase()
                                        .split(" ")
                                        .map(
                                            (s) =>
                                                s.charAt(0).toUpperCase() +
                                                s.substring(1)
                                        )
                                        .join(" ")}
                                </h4>
                                <div className="row align-items-center">
                                    <div className="col-12 col-md-3">HP</div>
                                    <div className="col-12 col-md-9">
                                        <div className="progress">
                                            <div
                                                className="progress-bar"
                                                role="progressBar"
                                                style={{
                                                    width: `${pokemon.stats.hp}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {pokemon.stats.hp}
                                                </small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="row align-items-center">
                                    <div className="col-12 col-md-3">
                                        ATTACK
                                    </div>
                                    <div className="col-12 col-md-9">
                                        <div className="progress">
                                            <div
                                                className="progress-bar"
                                                role="progressBar"
                                                style={{
                                                    width: `${pokemon.stats.attack}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {pokemon.stats.attack}
                                                </small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="row align-items-center">
                                    <div className="col-12 col-md-3">
                                        DEFENSE
                                    </div>
                                    <div className="col-12 col-md-9">
                                        <div className="progress">
                                            <div
                                                className="progress-bar"
                                                role="progressBar"
                                                style={{
                                                    width: `${pokemon.stats.defense}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {pokemon.stats.defense}
                                                </small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="row align-items-center">
                                        <div className="col-12 col-md-3">
                                            WEIGHT
                                        </div>
                                        <div className="col-12 col-md-9">
                                            {pokemon.weight}kg
                                        </div>
                                        <div className="col-12 col-md-3">
                                            HEIGHT
                                        </div>
                                        <div className="col-12 col-md-9">
                                        {pokemon.height}m
                                        </div>
                                     <div className="button">
                                        <div className="col-6 col-md-8">
                                            <Link to='/'>
                                            <button>
                                                Back
                                            </button>
                                            </Link>
                                        </div>
                                    </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
}

export default Pokemon;