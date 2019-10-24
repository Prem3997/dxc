function start(response){
    console.log("Request handler 'start' was called.");
    var body = '<html>' +
        '<head>' +
        '<meta http-equiv="Content-Type" content="text/html; ' +
        'charset=UTF-8" />' +
        '</head>' +
        '<body>' +
        '<form action="/upload" method="post">' +
        '<textarea name="text" rows="20" cols="60"></textarea>' +
        '<textarea name="text1" rows="20" cols="60"></textarea>' +
        '<input type="text" name="username"/>'+
        '<input type="submit" value="Submit text" />' +
        '</form>' +
        '</body>' +
        '</html>';
    response.writeHead(200, { "Content-Type": "text/html" });
    response.write(body);
    response.end();
}
function upload(response,postData){
    console.log("Request Handler  upload was called ")
    response.writeHead(200,{"content-type":"text/plain"})
    response.write("You Have sent:"+postData)
    response.end()
}
function download(){
    console.log("Request Handler  donwload was called ")
}
function imageUpload(){
    console.log("Request Handler  imageupload was called ")
}
exports.start=start;
exports.upload=upload;
exports.download=download;
exports.imageUpload=imageUpload