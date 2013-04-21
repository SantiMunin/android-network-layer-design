var express = require("express"),
    app = express(),
    port = process.env.PORT || 8000;


// Config

app.configure(function () {
    app.use(express.logger());
    app.use(express.bodyParser());
    app.use(express.errorHandler({ dumpExceptions:true, showStack:true }));
});

app.get('/', function (req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.send('/login/<user>/<password>\n/classes/<text>\n');
});

app.get('/login/:user/:password', function (req, res) {
    var user = req.params.user;
    var password = req.params.password;
    res.setHeader('Content-Type', 'application/json');
    console.log('User: ' + user);
    console.log('Pasword: ' + password);
    if ((user === 'user1') && (password === 'password1')) {
        res.send('{\"status\": \"OK\"}');
    } else {
        res.send('{\"status\": \"WRONG_CREDENTIALS\"}');
    }
});

app.get('/classes/:text', function (req, res) {
    var text = req.params.text
    res.setHeader('Content-Type', 'application/json');
    if (text === 'systems') {
        res.send('{\"classes\": [{\"name\":\"Systems I\", \"teacher\":\"Teacher I\", \"hours\":200 }, {\"name\":\"Systems II\", \"teacher\":\"Teacher II\",\"hours\":150 }]}');
    } else {
        res.send('{\"classes\":[]}');
    }
});

console.log('Listening @ ' + port);

// Launch server
app.listen(port);
