var mongoose=require("mongoose")
module.exports = function (app) 
{
    app.get('/todo', function (request, response) 
    { 
        mongoose.connect("mongodb+srv://root:root@cluster0-8qoer.mongodb.net/test?retryWrites=true&w=majority")
        console.log("MongoDB Cloud Connected")
        response.render('ToDo',{
            todo:['Code','EAT','SLEEP']
        })
    });
    app.post('/todo', function (request, response) 
    { 
        response.send("TODO POST")
    });
    app.delete('/todo', function (request, response) 
    {
        response.send("TODO DELETE")
    });
};