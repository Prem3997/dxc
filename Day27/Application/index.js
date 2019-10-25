var fs=require("fs")
const http=require("http")
const hostname="127.0.0.1"
const port=8000
const server=http.createServer((request,response)=>{
    response.statusCode=200
    response.setHeader('content-Type','text/html')
    var myReadStream=fs.createReadStream(__dirname+'/index.html','utf-8')
    myReadStream.pipe(response)
})
server.listen(port,hostname,()=>{
    console.log(`Server Running at http://${hostname}:${port}`)
})