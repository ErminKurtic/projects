import React, { useState, useEffect } from "react";

const MovieBox = ({ title, release_date, characters }) => {
    const [toggleCharacters, setShowCharacters] = useState(false);
    const toggleShowCharacters = () => setShowCharacters((value) => !value);
    const [movieCharacters] = useState([]);

    const toggleHandler = () => {
        toggleShowCharacters();
    };

    useEffect(() => {
        Promise.all(
            characters.map((character) =>
                fetch(character)
                    .then((response) => response.json())
                    .then((responseBody) => {
                        movieCharacters.push(responseBody);
                        movieCharacters.sort((a, b) =>
                            a.name.localeCompare(b.name)
                        );
                    })
            )
        );
    }, []);

    return (
        <div className="movieBox" onClick={() => toggleHandler()}>
            <h1>{title}</h1>
            <h2>{release_date}</h2>
            {toggleCharacters && (
                <ol className="charBox">
                    <p>Characters in movie:</p>
                    {movieCharacters.map((item, index) => (
                        <li key={index}>{item.name}</li>
                    ))}
                </ol>
            )}
        </div>
    );
};

export default MovieBox;
