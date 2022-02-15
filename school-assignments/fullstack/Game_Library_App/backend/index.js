const express = require("express");
const cors = require("cors");

//Initialize express
const app = express();
const mongoose = require("mongoose");

//Middleware for parsing json data
app.use(express.json());
app.use(cors());

//connect to mongodb database
mongoose.connect(
  process.env.MONGODB_URI ||
    "mongodb+srv://ermin_michael:megahane69@express-mongo-database.ks3sb.mongodb.net/myFirstDatabase?retryWrites=true&w=majority",
  { useNewUrlParser: true, useUnifiedTopology: true, autoIndex: true },
  () => console.log("Connected to database")
);

//import express router initialized in routes/api.js
const router = require("./routes/api");
app.use("/api", router);

//Set port variable
const PORT = process.env.PORT || 5000;

//Listen for requests on PORT variable
app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});
