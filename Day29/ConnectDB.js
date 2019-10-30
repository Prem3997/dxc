var selectDB=function(port,dbname){
    if(!port){
        port=27017
    }
    if(!dbname){
        dbname="dxcdb"
    }
    dbname=connect("localhost:"+port+"/"+dbname)
    return db
}