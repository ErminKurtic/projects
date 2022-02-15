import React, { useState } from "react";

export const GameCard = (props) => {
  const { _id, title, genre, playtime } = props.game;
  const { games, setGames } = props;
  const [isEditing, setIsEditing] = useState(false);
  const [editGame, setEditGame] = useState({
    title: title,
    genre: genre,
    playtime: playtime,
  });

  const toggleEdit = () => setIsEditing(!isEditing);

  const deleteGame = () => {
    fetch(`http://localhost:5000/api/deletepost/${_id}`, {
      method: "DELETE",
    }).then(() => {
      fetch("http://localhost:5000/api/getposts")
        .then((data) => data.json())
        .then((data) => {
          setGames(data.posts);
        });
    });
  };

  const submitEdit = (event) => {
    event.preventDefault();
    fetch(`http://localhost:5000/api/updatepost/${_id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(editGame),
    }).then(() => {
      fetch("http://localhost:5000/api/getposts")
        .then((data) => data.json())
        .then((data) => {
          setGames(data.posts);
        });
    });
    toggleEdit();
  };

  const handleChange = (event) => {
    setEditGame({ ...editGame, [event.target.name]: event.target.value });
  };

  if (isEditing) {
    return (
      <div
        style={{
          borderBottom: "1px solid black",
          borderTop: "1px solid black",
          paddingBottom: "15px",
          paddingTop: "15px",
        }}
      >
        <form onSubmit={submitEdit}>
          <input name="title" value={editGame.title} onChange={handleChange} />
          <br />
          <input name="genre" value={editGame.genre} onChange={handleChange} />
          <br />
          <input
            name="playtime"
            value={editGame.playtime}
            onChange={handleChange}
          />
          <br />
          <button onClick={toggleEdit}>Cancel</button>
          <button type="submit">Save changes</button>
        </form>
      </div>
    );
  }

  return (
    <div style={{ borderBottom: "1px solid black", paddingBottom: "15px" }}>
      <h3 style={{ fontWeight: "bold", textDecoration: "underline" }}>
        {title}
      </h3>
      <p>Genre: {genre}</p>
      <p>Time played: {playtime} hours</p>
      <button onClick={toggleEdit}>Edit</button>
      <button onClick={deleteGame}>Delete</button>
    </div>
  );
};
