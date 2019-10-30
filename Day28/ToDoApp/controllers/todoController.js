var data = [];
var MongoClient = require('mongodb').MongoClient
var url = 'mongodb://localhost:27017'
const bodyParser = require("body-parser")
//Model
var db
MongoClient.connect(url, (err, client) => {
    db = client.db('itemdb')
    db.collection('todo').find({}).toArray(function (err, docs) {
        docs.forEach(function (doc) {
            data=docs
            console.log(docs)
        })
        console.log("Connected Successfully")
    })
})
module.exports = function (app) {
    app.use(
        bodyParser.urlencoded({
            extended: true
        })
    )
    app.use(bodyParser.json())
    app.get('/todo', function (request, response) {
        response.render("todo", { todos: data });
    });
    app.post('/todo', function (request, response) {
        var addItem = request.body.itemName
        console.log("Item to be add:" + addItem)
        var myObj = { addItem: addItem }
        db.collection('todo').insertOne(myObj, function (err) {
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
