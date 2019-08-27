document.addEventListener('DOMContentLoaded', function () {
    var elems = document.querySelectorAll('.collapsible');
    // var instances = M.Collapsible.init(elems, options);
});

$(document).ready(function () {
    $('.collapsible').collapsible();
});

function getMessages(contactId) {
    $.get("chat/messages?contactId=" + contactId, function (data) {
        $("#card").empty();
        data.forEach(function (element) {

            // let div = document.createElement('div');
            // div.className = "row";
            // div.id = "#card2";
            //
            // let div1 = document.createElement('div');
            // div1.id = "card3";
            // div1.className = "col s12 m6";
            //
            // let div2 = document.createElement('div');
            // div2.id = "card4";
            // div2.className = "card teal darken-3";
            //
            // let div3 = document.createElement('div');
            // div3.id = "msgAcceptor";
            // div3.className = "card-content white-text";
            //
            // let text = document.createElement('p');
            // text.innerHTML = element.message;
            // let name = document.createElement('span');
            // name.className = "card-title";
            // name.innerHTML = element.user.firstname;
            //
            // $("#card").append(div);
            // $("#card2").append(div1);
            // $("#card3").append(div2);
            // $("#card4").append(div3);
            // $("#msgAcceptor").append(name);
            // $("#msgAcceptor").append(text);

            $('<div>', {
                className : 'row',
                id : 'card2'
            }).appendTo('#card');
            $('<div>', {
                className : 'col s12 m6',
                id : 'card3',
            }).appendTo('#card2');
            $('<div>', {
                className : 'card teal darken-3',
                id : 'card4',
            }).appendTo('#card3');
            $('<div>', {
                className : 'card-content white-text',
                id : 'msgAcceptor',
            }).appendTo('#card4');
            $('<span>', {
                className : 'card-title',
                text : element.user.firstname,
            }).appendTo('#msgAcceptor');
            $('<p>', {
                text : element.message,
            }).appendTo('#msgAcceptor');

        });
    });
}

function sendMessage() {
    let message = ($("#icon_prefix2").val());
    $.ajax({
        type : "POST",
        url : 'chat/send',
        data : message
    });
    // $.post("chat/send", $("#messageToSend").serialize(), function (data) {
    // let test = $("#messageToSend");
    // alert(test);
    // });
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
