import React, { useState, useEffect } from "react";
import MovieBox from "./components/MovieBox";
import { RingLoader } from "react-spinners";

export const App = () => {
    const [allMovies, setAllMovies] = useState([]);
    const [loading, setLoading] = useState(true);

    const SWAPI_URL = "https://swapi.py4e.com/api/films";
    const loadTimer = 1000; //adds 1s to load

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(SWAPI_URL);
            const data = await response.json();

            if (data) {
                setAllMovies(data.results);
                setLoading(false);
            }
        };
        setTimeout(() => {
            fetchData();
        }, loadTimer);
    }, []);

    return (
        <div className="outerDiv">
            {loading && <RingLoader color={"#FFD700"} size={500} />}
            <div className="innerDiv">
                {allMovies.map((Info, index) => (
                    <MovieBox
                        key={index}
                        title={Info.title}
                        release_date={Info.release_date}
                        characters={Info.characters}
                    />
                ))}
            </div>
        </div>
    );
};

export default App;
