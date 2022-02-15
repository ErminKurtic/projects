const express = require("express");

//initialize express router
const router = express.Router();
const Post = require("../models/Post");

//Add post route
router.post("/newpost", (req, res) => {
  const newPost = new Post({
    title: req.body.title,
    genre: req.body.genre,
    playtime: req.body.playtime,
  });
  newPost.save((err) => {
    if (err) {
      res.status(500).json({ message: "An error occured saving!" });
    } else {
      res.status(200).json({ message: "Post was successfully created" });
    }
  });
});

//Get all posts route
router.get("/getposts", (req, res) => {
  Post.find({}, (err, posts) => {
    if (err) {
      res.status(500).json({ message: "An error occured getting" });
    } else {
      res.status(200).json({ posts });
    }
  });
});

//Update post route
router.put("/updatepost/:id", (req, res) => {
  const { title, genre, playtime } = req.body;
  const _id = req.params.id;
  Post.findByIdAndUpdate(_id, { title, genre, playtime }, (err) => {
    if (err) {
      res.status(500).json({ message: "An error occured updating" });
    } else {
      res.status(200).json({ message: "Post was successfully updated!" });
    }
  });
});

//Delete post route
router.delete("/deletepost/:id", (req, res) => {
  const _id = req.params.id;
  Post.findByIdAndDelete(_id, (err) => {
    if (err) {
      res.status(500).json({ message: "An error occured deleting" });
    } else {
      res.status(200).json({ message: "Post was successfully deleted!" });
    }
  });
});

module.exports = router;
