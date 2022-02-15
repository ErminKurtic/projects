"use strict";
//user can only login with these names.
let usernames = ["yazeen", "ec", "softhouse"];
let form = "";
let userInput = "";

//Function that calls all other functions in order
//--Don't modify--
function init() {
  initLoginForm();
  initLabel();
  initInput();
  initButton();
}

function initLoginForm() {
  //Add code here to:
  //create and add form element to the Dom.
  form = document.createElement("form");
  form.setAttribute("onsubmit", "return false");
  document.body.appendChild(form);
}

function initLabel() {
  //Add code here to:
  //create label element and set the lable to "username" (TIP: use .textContent).
  //Add it to the form element. (TIP: use .appendChild).
  const label = document.createElement("label");
  label.textContent = "Username";
  form.appendChild(label);
}

function initInput() {
  //Add code here to:
  //create input element and set it to be requried (TIP: use .required = true).
  //Add it to the form element. (TIP: use .appendChild).
  userInput = document.createElement("input");
  userInput.required = "true";
  form.appendChild(userInput);
}

function initButton() {
  //create button element and set the text to "login" (TIP: use .textContent)
  ////Add it to the form element. (TIP: use .appendChild).

  //Add click eventListener for button and call validateLoginInfo function inside it.
  //if validateLoginInfo is true alert user with "Welcome" text.
  //if validateLoginInfo is false add border style to the input element: "3px solid red". (TIP: use .style.border).
  const loginButton = document.createElement("button");
  loginButton.textContent = "Login";
  form.appendChild(loginButton);

  loginButton.addEventListener("click", function () {
    if (validateLoginInfo()) {
      alert("Welcome");
    } else {
      userInput.style.border = "3px solid red";
    }
  });
}

function validateLoginInfo() {
  //Get the input using form input element (TIP: use .value)
  //if the username is in the usernames array return true if not return false.
  let checkUsername = false;

  usernames.forEach(function (value) {
    if (userInput.value == value) {
      checkUsername = true;
    }
  });
  return checkUsername;
}

// - - - - Skrivet med vanlig forloop/forEach-loop (sparar mest för min egen skull) - - - -

// for (let i = 0; i < usernames.length; i++) {
//   if (userInput.value == usernames[i]) {
//     checkUsername = true;
//   }
// }
// return checkUsername;

//Write code here to call the init function only after the dom has been loaded (TIP: check "DOMContentLoaded" event)
window.addEventListener("DOMContentLoaded", init);
