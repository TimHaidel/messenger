document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems, options);
});

$(document).ready(function () {
    $('.collapsible').collapsible();
});

function getMessages() {
    // alert($("#contact").val());
    $.post("chat/messages", $("#contactInfo").serialize(), function (data) {
        // alert(data.message);

        data.forEach(function (element) {

            let text = document.createElement('p');
            text.innerHTML = element.message;

            $("#msgAcceptor").append(text);
        });
        // var content = $(data).find("#message");
        // console.log(content);
        // $("#chatbox").empty().append(content);
    });
}

function sendMessage() {
    $.post("chat/send", $("#messageToSend").serialize(), function (data) {
        let test = $("#messageToSend");
        alert(test);
    });
}

// Or with jQuery

// function getMessages(contextUrl, acceptorId) {
// $.get(contextUrl + "/chat/messages", function (messages) {
// displayMessages(messages);
// });
//
// }
//
// function displayMessages(messages) {
// $.each(messages, function (key, value) {
// $('#msgAcceptor').append(
// $("<div></div>").attr("value", value.id).text(value.message));
// });
// }
//
// function sendMessage(contextUrl, message) {
// $.get(contextUrl + "/chat/send", function (message) {
// displayMessage(message);
// });
// }
//
// function displeyMessage(message) {
// $('#msgInitiator').append(
// $("<div></div>").attr("value", message.id).text(message.message));
// }
