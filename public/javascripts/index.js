
function sendMail() {
  var form = buildForm();
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    var DONE = 4; // readyState 4 means the request is done.
    var OK = 200; // status 200 is a successful return.
    if (xhr.readyState === DONE) {
      if (xhr.status === OK)
        console.log(xhr.responseText); // 'This is the returned text.'
      } else {
      }
    }
  xhr.open("POST", "/mails/", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify(form));
}

function buildForm(){
  return {
    name: document.getElementById('name').value,
    phone: document.getElementById('phone').value,
    order: document.getElementById('order').value,
    description: document.getElementById('description').value,
    mail: document.getElementById('mail').value
  }
}
