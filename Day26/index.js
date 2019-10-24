var server=require('./Server')
var route=require('./route')
var requestHandlers=require('./requestHandler')

var handle={}
handle["/"]=requestHandlers.start
handle["/start"]=requestHandlers.start
handle["/upload"]=requestHandlers.upload
handle["/download"]=requestHandlers.download
server.start(8888,route.route,handle)