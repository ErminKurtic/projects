import React, { Component } from "react";
import { Link } from "react-router-dom";
import { visitedPokemonContext } from '../../App';

const PokemonCard = (props) => {
    const { visitedPokemons, addVisistedPokemon } = React.useContext(visitedPokemonContext);
    
    return (
        <div className="col-md-3 col-sn-6 mb-5">
            <Link onClick={() => addVisistedPokemon(props.index)} to={`pokemon/${props.index}`}>
                <div className="card">
                    <h5 className="card-header">
                        {props.index}
                    </h5>
                    <div className="picture">
                        {visitedPokemons.includes(props.index) && (
                            <img src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${props.index}.png`} alt={props.name}/>
                        )}
                    </div>
                    <div className="card-header">
                        <h3>{props.name.toUpperCase()}</h3>
                    </div>
                </div>
            </Link>
        </div>
    );
};


export default PokemonCard;