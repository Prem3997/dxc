var fs=require("fs")
var fileData=fs.readFileSync("takeHome.txt","utf-8")
console.log(fileData)
fs.writeFileSync("ddata.txt",fileData)
fs.readFile("takeHome.txt","utf-8",function(err,data){
    if(err){
        console.log(err.message)
    }
    else{
        console.log(data)
    }
})
console.log("done")