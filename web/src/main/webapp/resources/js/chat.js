$(document).ready(function () {
    $('.tabs').tabs();
    $('.collapsible').collapsible();
    // $(".resizable").resizable();
});

$('#textarea1').val('New Text');
M.textareaAutoResize($('#textarea1'));

var groupIdGlob;
function getMessages(groupId) {
    groupIdGlob = groupId;
    let tempLength;
    // Логику в контроллер
    var requestMessages=function () {
        $.get("chat/messages?groupId=" + groupId, function(data) {
       if(tempLength !== data.length) {
           M.toast({html: 'I am a toast!'})
           printMessages(data);
           tempLength = data.length;
       }
    });
    }
   requestMessages();
    setInterval(requestMessages, 3000);
}




function toGroup(contactId) {
    $.get("chat/group?contactId=" + contactId, function (data) {
       getMessages(data);
    });
    
}

function printMessages(data) {
    let loggedUserId = $('#loggedUserId').val();
    $(".chatbox").empty();
  
    data.forEach(function (element) {
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
    let messageToSend = {
            message : ($("#icon_prefix2").val()),
            userGroupId : groupIdGlob
    };

    console.log(messageToSend);
    $.ajax({
        type : "POST",
        url : 'chat/send',
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(messageToSend),
        processData:false
    });
}


