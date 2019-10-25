var express = require("express");
var toDoController=require("./Controller/ToDoController")
var app = express();
app.set("view engine", "ejs");
app.use("/assets", express.static("./assets"));
toDoController(app)
app.listen(3000);
console.log("You are listening to port 3000");