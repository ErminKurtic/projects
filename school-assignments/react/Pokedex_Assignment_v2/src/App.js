import React, { Component, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/layout/Navbar";
import Dashboard from "./components/layout/Dashboard";
import { HashRouter as Router, Route, Switch } from "react-router-dom";
import Pokemon from "./components/pokemon/Pokemon";
import "./App.css";

export const visitedPokemonContext = React.createContext([]);

const App = () => {
    const [visitedPokemon, setVisitedPokemon] = useState([]);
    
    const addVisistedPokemon = (index) => {
        setVisitedPokemon([...visitedPokemon, index])
    };

    return (
        <visitedPokemonContext.Provider
            value={{
                visitedPokemons: visitedPokemon,
                addVisistedPokemon: addVisistedPokemon
            }}>
            <Router>
                <div className="App">
                    <Navbar />
                    <div className="container">
                        <Switch>
                            <Route exact path="/" component={Dashboard} />
                            <Route
                                exact
                                path="/pokemon/:pokemonIndex"
                                component={Pokemon}
                            />
                        </Switch>
                    </div>
                </div>
            </Router>
        </visitedPokemonContext.Provider>
    );
}

export default App;
