document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems, options);
});

// Or with jQuery

$(document).ready(function () {
    $('.collapsible').collapsible();
});

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
