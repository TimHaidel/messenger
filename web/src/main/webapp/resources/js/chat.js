$(document).ready(function () {
    $('.tabs').tabs();
    $('.collapsible').collapsible();
    $('.modal').modal();
    $('.sidenav').sidenav();
    $('.dropdown-trigger').dropdown();
    // $(".resizable").resizable();
    
});

// $('#textarea1').val('New Text');
// M.textareaAutoResize($('#textarea1'));

function getPinedMessages() {
    $.get("message/getpined", function (data){
       printPinnedMessages(data);
    });
}
function printPinnedMessages(data) {
    $("#slide-out").empty();
    data.forEach(function(element) {
        var unpin = "unPinMessage(" + element.id + ")";
        $('<i>', {
            name : 'pin',
            class : 'tiny material-icons',
            text : 'message',
            onclick : unpin,
        }).css('cursor','pointer').appendTo('#slide-out');
        $('<li>', {
            class: 'collection-item',
            text : element.message,
        }).appendTo('#slide-out');
       
    })
}

function unPinMessage(messageId) {
    $.get("message/unpin?messageId=" + messageId, function() {
        getPinedMessages();
    });
}

 $('.autocomplete').keypress(function(){
 let url = 'chat/autocomplete?field=' + $('#autocomplete-input').val();
 $(function (){
 $.ajax({
 type: 'GET',
 url: url,
 success: function(response) {
 var userArray = response;
 var dataUser = {};
 for (var i = 0; i < userArray.length; i++) {
 dataUser[userArray[i].email] = userArray[i].flag;
                                                                       
 }
          
 $('input.autocomplete').autocomplete({
 data: dataUser,
 limit: 5,
 });
 }
 });
 }) ;
 });

function addContact(autocomplete) {
    $.get("chat/contact?contactEmail=" + autocomplete, function () {
        location.reload();
     });
}

    
var groupIdGlob;
var tempGroupId;
var intervalId;
function getMessages(groupId) {
    $("#messageForm").show();
    groupIdGlob = groupId;
    var tempLength;
    
    // Логику в контроллер
    var requestMessages=function () {
        $.get("chat/messages?groupId=" + groupId, function(data) {
       if(tempLength !== data.length) {
           printMessages(data);
           tempLength = data.length;
           
       }
       if(tempGroupId != groupId) {
           clearInterval(intervalId);
           tempGroupId = groupId;
           intervalId = setInterval(requestMessages, 3000);
        }
    });
    }
    requestMessages(); 
    
   
}





function toGroup(contactId) {
    $.get("chat/group?contactId=" + contactId, function (data) {
       getMessages(data);
    });
    
}
function pinMessage(messageId) {
    $.get("message/pin?messageId=" + messageId);
}

function printMessages(data) {
    let loggedUserId = $('#loggedUserId').val();
    $(".chatbox").empty();
    // debugger;
    data.forEach(function (element) {
        if(element.currentUser){
            var pin = "pinMessage(" + element.id + ")";
            
            $('<i>', {
                class : 'tiny material-icons',
                text : 'message',
                onclick : pin,
                
            }).css('align','right').css('cursor','pointer').appendTo( $('<div>', {
                text : element.user.firstname,
            }).css('text-align','right').appendTo('.chatbox')
           );
            
           
            // Переписать, добавить дату
            $('<p>', {
                class : 'message-content',
                text : element.message,
                }).appendTo(
                     $('<div>', {
                     class : 'message-orange',
                     }).appendTo('.chatbox'));
            
        } else {
            var pin = "pinMessage(" + element.id + ")";
            $('<div>', {
                text : element.user.firstname,
            }).appendTo('.chatbox');
            $('<i>', {
                name : 'pin',
                class : 'tiny material-icons',
                text : 'message',
                onclick : pin,
            }).css('cursor','pointer').appendTo('.chatbox');
            
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

    $.ajax({
        type : "POST",
        url : 'chat/send',
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(messageToSend),
        processData:false
    });
    $('#icon_prefix2').val('');
}


