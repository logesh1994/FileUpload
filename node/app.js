/*var fs = require('fs');
var request = require('request');

request.post({
   url: 'http://localhost:8080/serviceApi/fileUpload',
    formData: {
        file: fs.createReadStream('TOp Secret.txt'),
        token: '### access token ###',
        filetype: 'text',
        filename: 'TOp Secret',
        channels: 'sample',
        title: 'sampletitle',
    },
	headers: {"Content-Type": "multipart/form-data;"},
}, function(error, response, body) {
    console.log(body);
});*/

var fs = require('fs');
var request = require('request');
var jsonUpload = { name: "Logesh" , age: "25"};
var formData = {
    'file': fs.createReadStream('Top Secret.txt'),
    'jsonUpload': JSON.stringify(jsonUpload)
};
var uploadOptions = {
    "url": "http://localhost:8080/serviceApi/fileUpload",
    "method": "POST",
    "formData": formData
	/*"headers": {"Content-Type": "multipart/form-data;"}*/
}
var req = request(uploadOptions, function(err, resp, body) {
    if (err) {
        console.log('Error ', err);
    } else {
        console.log('upload successful', body)
    }
});