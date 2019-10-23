var http=require("http")
var url=require("url")
function start(portNumber,route){
    function onRequest(request,response){
        if(request.url==="/favicon.ico"){
            response.writeHead(200,{"content-type":"image/x-icon"})
            response.end()
            return
        }
        response.writeHead(200,{"content-type":"text-plain"})
        var pathname=url.parse(request.url).pathname
        console.log("1.The Requested current Url is :"+pathname)
        route(pathname)
        console.log("3.The Requested current Url is :"+pathname)
        response.write("Hi Request and Response Created" )
        response.end();
    }
    var server=http.createServer(onRequest)
    server.listen(portNumber)
    console.log("Server created on Port:"+portNumber)
}
exports.start=start