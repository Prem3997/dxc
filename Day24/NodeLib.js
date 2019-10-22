var http=require("http")
var fs=require("fs")
var formidable=require("formidable")

function onRequest(request,response){
    response.writeHead(200,{"content-type":"text-html"})
    response.write("Server Created")
    response.end()
}
var server=http.createServer(function(request,response){
    response.writeHead(200,{"content-type":"text-html"})
    response.write("Server Created")
    response.end()
})
server.listen(8888)
console.log("Server Started on Port Nubmer:8888")
var server2=http.createServer(onRequest).listen(8000)
console.log("Server Started on Port Nubmer:8000")