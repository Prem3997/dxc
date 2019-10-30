var data = [];
var mongoose = require("mongoose")
const bodyParser=require("body-parser")
 //connection cloud
 mongoose.connect("mongodb://tufail:ahmed123@ds339348.mlab.com:39348/todoappdxc")
 //schema
 var todoSchema = new mongoose.Schema({
     item: String
 })
 //Model
 var Todo = mongoose.model('Todo', todoSchema)
module.exports = function (app) {
    app.use(
        bodyParser.urlencoded({
            extended:true
        })
    )
    app.use(bodyParser.json())
    app.get('/todo', function (request, response) {
        Todo.find(function(err,d){
            data=d
        })
        response.render("todo", { todos: data });
    });
    app.post('/todo', function (request, response) {
        var addItem=request.body.itemName
        console.log("Item to be add:"+addItem)
        Todo({ item: addItem }).save(function (err) {
            if (err)
                console.error(err);
            console.log("item saved");
        })
        response.render("todo", { todos: data });
    });
    app.delete('/todo', function (request, response) {
        response.send("TODO DELETE")
    });
};
