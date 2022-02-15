import axios from "axios";
import React, { Component } from "react";

export default class Pokemon extends Component {
    state = {
        name: "",
        pokemonIndex: "",
        imageUrl: "",
        types: [],
        description: "",
        stats: {
            hp: "",
            attack: "",
            defense: "",
            speed: "",
            specialAttack: "",
            specialDefense: "",
        },
    };

    async componentDidMount() {
        const { pokemonIndex } = this.props.match.params;

        //URL for Pokemon Information
        const pokemonUrl = `https://pokeapi.co/api/v2/pokemon/${pokemonIndex}/`;
        //const pokemonSpeciesUrl = `https://pokeapi.co/api/v2/pokemon-species/${pokemonIndex}/`;

        // Get Pokemon Information
        const pokemonRes = await axios.get(pokemonUrl);

        const name = pokemonRes.data.name;
        const imageUrl = pokemonRes.data.sprites.front_default;
        //this.setState({ name });

        let { hp, attack, defense, speed, specialAttack, specialDefense } = "";

        pokemonRes.data.stats.map((stat) => {
            switch (stat.stat.name) {
                case "hp":
                    hp = stat["base_stat"];
                    break;
                case "attack":
                    attack = stat["base_stat"];
                    break;
                case "defense":
                    defense = stat["base_stat"];
                    break;
                case "speed":
                    speed = stat["base_stat"];
                    break;
                case "special-attack":
                    specialAttack = stat["base_stat"];
                    break;
                case "special-defense":
                    specialDefense = stat["base_stat"];
                    break;
            }
        });

        // convert decimeter to feet...The + 0.0001 * 100) / 100 is for rounding to 2 decimal places
        const height =
            Math.round((pokemonRes.data.height * 0.328084 + 0.0001) * 100) /
            100;

        // converts to pounds
        const weight =
            Math.round((pokemonRes.data.weight * 0.220462 + 0.0001) * 100) /
            100;

        const types = pokemonRes.data.types.map((type) => type.type.name);

        this.setState({
            imageUrl,
            pokemonIndex,
            name,
            types,
            stats: {
                hp,
                attack,
                defense,
                speed,
                specialAttack,
                specialDefense,
            },
        });
    }

    render() {
        return (
            <div className="col">
                <div className="card">
                    <div className="card-header">
                        <div className="row">
                            <div className="col-5">
                                <h5>{this.state.pokemonIndex}</h5>
                            </div>
                            <div className="col-7">
                                <div className="float-right">
                                    {this.state.types.map((type) => (
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
                                    src={this.state.imageUrl}
                                    className="card-img-top rounded mx-auto mt-2"
                                />
                            </div>
                            <div className="col-md-9">
                                <h4 className="mx-auto">
                                    {this.state.name
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
                                                    width: `${this.state.stats.hp}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {this.state.stats.hp}
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
                                                    width: `${this.state.stats.attack}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {this.state.stats.attack}
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
                                                    width: `${this.state.stats.defense}%`,
                                                }}
                                                aria-valuenow="25"
                                                aria-valuemin="0"
                                                aria-valuemax="100"
                                            >
                                                <small>
                                                    {this.state.stats.defense}
                                                </small>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="button">
                                        <div className="col-6 col-md-8">
                                            <button
                                                onClick={
                                                    this.props.history.goBack
                                                }
                                            >
                                                Back
                                            </button>
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
}
