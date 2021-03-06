//modules
var express = require('express');
var multer = require('multer');
var bodyParser = require('body-parser');

//express
app = express();

//credentials
credentials = require('./credentials.js');

//bodyParser + multer
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(multer());

//session
app.use(require('cookie-parser')(credentials.cookieSecret));

//routes
require("./routes/users.js");
require("./routes/signin.js");
require("./routes/mycharacters.js");
require("./routes/lobbies.js");

//server start
app.listen(8080); //zmien na 80 w przyszlosci
