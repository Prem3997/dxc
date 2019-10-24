var http=require("http")
var url=require("url")
var fs=require("fs")
function start(portNumber,route,handle){
    function onRequest(request,response){
        var pathname=url.parse(request.url).pathname
        if(request.url==="/favicon.ico"){
            response.writeHead(200,{"content-type":"image/x-icon"})
            response.end()
            return
        }
        var postData=""
        var count=0
        request.setEncoding("utf-8")
        request.addListener("data",function(postDataChunk){
            postData+=postDataChunk

            console.log("Recieved PostData Chunk"+postDataChunk+"")
            count++
            console.log(count)
            fs.writeFileSync('./file'+count,postDataChunk)
        })
        request.addListener("end",function(){
            console.log("Finished Reading Data")
            route(pathname,handle,response,postData)
        })
    }
    var server=http.createServer(onRequest)
    server.listen(portNumber)
    console.log("Server created on Port:"+portNumber)
}
exports.start=start