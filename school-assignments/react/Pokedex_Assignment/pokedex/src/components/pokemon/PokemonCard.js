import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class PokemonCard extends Component {
    state = {
        name: "",
        imageUrl: "",
        pokemonIndex: "",
    };

    componentDidMount() {
        const { name, url } = this.props;
        const pokemonIndex = url.split("/")[url.split("/").length - 2];
        const imageUrl = `https://github.com/PokeAPI/sprites/blob.master/sprites/pokemon/${pokemonIndex}.png?raw=true`;

        this.setState({
            name: name,
            imageUrl: imageUrl,
            pokemonIndex: pokemonIndex,
        });
    }

    render() {
        return (
            <div className="col-md-3 col-sn-6 mb-5">
                <Link to={`pokemon/${this.state.pokemonIndex}`}>
                    <div className="card">
                        <h5 className="card-header">
                            {this.state.pokemonIndex}
                        </h5>
                        <div className="card-header">
                            <h3>{this.state.name.toUpperCase()}</h3>
                        </div>
                    </div>
                </Link>
            </div>
        );
    }
}
