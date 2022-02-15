"use strict";

let library = [];

function addBook(name, topic, pages, ISBN) {
  this.name = name;
  this.topic = topic;
  this.pages = pages;
  this.ISBN = ISBN;

  this.getBookInfo = function (id) {
    console.log("Name: " + library[id].name);
    console.log("Topic: " + library[id].topic);
    console.log("Pages: " + library[id].pages);
    console.log("ISBN: " + library[id].ISBN);
    console.log("- - - - - - - - - - - ");
  };
}

library.push(new addBook("Book1", "Topic1", 200, 12345));
library.push(new addBook("Book2", "Topic2", 300, 11111));
library.push(new addBook("Book3", "Topic3", 400, 22222));

let numberOfBooks = prompt(
  "How many books do you wish to apply to our collecition?:",
  "Insert amount here..."
);

for (let i = 0; i < numberOfBooks; i++) {
  let bookName = prompt("Name of book:", "Enter name here...");
  let bookTopic = prompt("Topic of the book:", "Enter topic here...");
  let amountOfPages = prompt("Amount of pages:", "Enter amount of pages...");
  let isbnNumber = prompt("ISBN Number of the book:", "Enter ISBN number...");

  library.push(new addBook(bookName, bookTopic, amountOfPages, isbnNumber));
}

for (let i = 0; i < library.length; i++) {
  library[i].getBookInfo(i);
}
