var fs = require('fs')
fs.mkdir('DXC', function () {
},fs.mkdir('CUST', function () {
},fs.mkdir('EMP', function () {
          fs.readFile("takeHome.txt", 'utf-8', function (err, data) {
                fs.writeFileSync('./EMP/ReadMe.txt', data)
            })
        })
    )
)