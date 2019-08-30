$(document).ready(function () {
    $('.tabs').tabs();
});

$(document).ready(function () {
    $('.collapsible').collapsible();
});

function getMessages(groupId) {
    let tempLength;
    // Логику в контроллер
    function requestMessages () {$.get("chat/messages?groupId=" + groupId, function(data) {
       if(tempLength != data.length) {
           
           printMessages(data);
           tempLength = data.length;
       }
    });
    }
    requestMessages();
    // setInterval(requestMessages, 3000);
}




function toGroup(contactId) {
    $.get("chat/group?contactId=" + contactId, function (data) {
       getMessages(data);
    });
    
}

function printMessages(data) {
    let loggedUserId = $('#loggedUserId').val();
    console.log(data);
    $(".chatbox").empty();
  
    data.forEach(function (element) {
        // нужен id legged user
        if(element.user.id === null){
            
        } else {
            
        }
        $('<div>', {
            text : element.user.firstname,
        }).appendTo('.chatbox');
        
       
        
        $('<p>', {
            class : 'message-content',
            text : element.message,
            }).appendTo(
                 $('<div>', {
                 class : 'message-blue',
                 }).appendTo('.chatbox')
               );
        
// $('div', {
// class : 'message-timestamp-left',
// text : '152'
// }).appendTo('.message-blue');
    });
    
}


// function getMessages1(contactId) {
// $.get("chat/messages?contactId=" + contactId, function (data) {
// $("#chatbox").empty();
// data.forEach(function (element) {
//
// $('<div>', {
// class : 'card blue-grey darken-1',
// id : 'card2',
// }).appendTo('#card');
// $('<div>', {
// class : 'card-content white-text',
// id : 'msgFrom',
// }).appendTo('#card2');
// $('<span>', {
// class : 'card-title',
// text : element.user.firstname,
// }).appendTo('#msgFrom');
// $('<p>', {
// text : element.message,
// }).appendTo('#msgFrom');
//            
// });
// });
// }



function sendMessage() {
    let message = ($("#icon_prefix2").val());
// JSON.stringify(message);
    
    // нужно id logged user, id group
    console.log(message);
    $.ajax({
        type : "POST",
        url : 'chat/send',
        contentType: "application/json; charset=utf-8",
        data : message
    });
    // $.post("chat/send", $("#messageToSend").serialize(), function (data) {
    // let test = $("#messageToSend");
    // alert(test);
    // });
}

