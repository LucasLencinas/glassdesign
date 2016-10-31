var express = require('express');
var router = express.Router();
var api_key = 'key-5bd724f94fa38e82a0a602ff3fcdb2dd';
var domain = 'mg.glassdesign';
var mailgun = require('mailgun-js')({apiKey: api_key, domain: domain});

router.post('/', function (req, res) {
  console.log("POST Req => " + JSON.stringify(req.body));
  var data = {
    from: 'web@glassdesign.com.ar',
    to: 'lllencinas@gmail.com',
    subject: 'Glassdesign request',
    text: JSON.stringify(req.body)
  };
  mailgun.messages().send(data, function (err, body) {
      if (err) {
          console.log("got an error: ", err);
          res.status(500).send('ERROR while sending the mail');
      }
      else {
          console.log(body);
          res.status(200).send('Mail sent to the administrator');
      }
  });
});

router.get('/', function(req, res, next) {
  console.log("GET Req => " + JSON.stringify(req.body));
  res.render('404.html');
});

module.exports = router;
