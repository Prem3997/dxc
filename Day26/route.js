function route(pathname,handle,response,postData){
    if(typeof handle[pathname]=='function'){
        console.log("Hello I am Routing:"+pathname)
        handle[pathname](response,postData)
    }
    else{
        console.log("Sorry no handlers for "+pathname)
    }
}
exports.route=route