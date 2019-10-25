var express=require("express")
var app=express()
app.set('view engine','ejs')

app.get("/",function(request,response){
    response.send("Hello World")
})
app.get("/displayProduct/:pId/orders/:oId",function(request,response){
    var data={
        name:'PremBalaji',
        address:'Krishnagiri',
        mobile: [9489730873,7708167167]
    }
    response.render("productDisplay",{
        datapId:request.params.pId,
        dataoId:request.params.oId,
        customerData:data
    })
})
app.post("/insertProduct",function(request,response){
    response.send("Insert")
})
app.put("/updateProduct",function(request,response){
    response.send("Put")
})
app.delete("/deleteProduct",function(request,response){
    response.send("Delete")
})
app.listen(8000)
console.log("Server started on port: 8000")