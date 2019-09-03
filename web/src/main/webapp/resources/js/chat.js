$(document).ready(function () {
    $('.tabs').tabs();
    $('.collapsible').collapsible();
    // $(".resizable").resizable();
});

var groupIdGlob;
function getMessages(groupId) {
    groupIdGlob = groupId;
    let tempLength;
    // Логику в контроллер
    function requestMessages () {$.get("chat/messages?groupId=" + groupId, function(data) {
       if(tempLength !== data.length) {
           
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
    // console.log(data);
    $(".chatbox").empty();
  
    data.forEach(function (element) {
        // нужен id legged user
        if(element.currentUser){
             $('<div>', {
                text : element.user.firstname,
            }).css('text-align','right').appendTo('.chatbox');
            
           
            // Переписать, добавить дату
            $('<p>', {
                class : 'message-content',
                text : element.message,
                }).appendTo(
                     $('<div>', {
                     class : 'message-orange',
                     }).appendTo('.chatbox'));
            
        } else {
            $('<div>', {
                text : element.user.firstname,
            }).appendTo('.chatbox');
            
           
            // Переписать, добавить дату
            $('<p>', {
                class : 'message-content',
                text : element.message,
                }).appendTo(
                     $('<div>', {
                     class : 'message-blue',
                     }).appendTo('.chatbox'));
        }
       
    });
    
}


function sendMessage() {
   

    
    // нужно id logged user, id group
    let messageToSend = {
            message : ($("#icon_prefix2").val()),
            groupId : groupIdGlob
    };

    // JSON.stringify(messageToSend);
    console.log(messageToSend);
    $.ajax({
        type : "POST",
        url : 'chat/send',
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(messageToSend),
        processData:false
    });
    // $.post("chat/send", $("#messageToSend").serialize(), function (data) {
    // let test = $("#messageToSend");
    // alert(test);
    // });
}


