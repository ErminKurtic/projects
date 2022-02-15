import React, { useState, useEffect } from "react";
import { GameCard } from "./GameCard";

export const LibraryPage = () => {
  const [games, setGames] = useState([]);
  const [newGame, setNewGame] = useState({
    title: "",
    genre: "",
    playtime: null,
  });

  useEffect(() => {
    fetch("http://localhost:5000/api/getposts/")
      .then((res) => res.json())
      .then((res) => {
        setGames(res.posts);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const changeInput = (event) => {
    setNewGame({ ...newGame, [event.target.name]: event.target.value });
  };

  const submitForm = (event) => {
    event.preventDefault();

    fetch("http://localhost:5000/api/newpost", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newGame),
    }).then(() => {
      fetch("http://localhost:5000/api/getposts")
        .then((data) => data.json())
        .then((data) => {
          setGames(data.posts);
        });
    });
  };

  return (
    <>
      <div style={{ paddingBottom: "15px", borderBottom: "1px dotted black" }}>
        <h2 style={{ textDecoration: "underline" }}>Add new game:</h2>
        <form onSubmit={submitForm}>
          <input name="title" placeholder="Game title" onChange={changeInput} />
          <br />
          <input name="genre" placeholder="Genre" onChange={changeInput} />
          <br />
          <input
            name="playtime"
            placeholder="Time played"
            onChange={changeInput}
          />
          <br />
          <button type="submit">Add Game</button>
        </form>
      </div>
      {games.map((game) => {
        return (
          <GameCard
            key={game._id}
            game={game}
            setGames={setGames}
            games={games}
          />
        );
      })}
    </>
  );
};
