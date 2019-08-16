// let websocket;
function init() {

}

function sendMessage() {
    let wsUrl = "ws://${contextPath}/sock/chat";
    writeToScreen("Connecting to " + wsUri);
    websocket = new WebSocket(wsUrl);
    websocket.onopen = function (evt) {
        writeToScreen("Connected !");
        doSend(icon_prefix2.value);
    };
    websocket.onmessage = function (evt) {
        writeToScreen("Received message: " + evt.data);
        websocket.close();
    };

    websocket.onerror = function (evt) {
        writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
        echo_websocket.close();
    };
}
function doSend(message) {
    echo_websocket.send(message);
    writeToScreen("Sent message: " + message);
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}
window.addEventListener("load", init, false);

// let chatUnit = {
// init() {
// // this.startbox = document.querySelector(".start");
// this.chatbox = document.querySelector(".chatbox");
//          
// this.chatbox = this.input-field.querySelector("button");
// this.nameInput = this.input-field.querySelector("input-field");
//          
// this.msgTextArea = this.chatbox.querySelector("textarea");
//          
// this.bindEvents();
//          
// },
//      
// bindEvents() {
// this.chatbox.addEventListener("click", e=>this.openSocket())
// this.msgTextArea.addEventListener("keyup", e=> {
// if (e.ctrlKey && e.keyCode===13) {
// alert("test");
// e.preventDefault();
// this.send();
// }
// })
// },
//      
// send() {
// this.sendMessage({
// name:this.name,
// text:this.msgTextArea.value
// });
// },
//      
// onOpenSock () {
//          
// },
//      
// onMessage (parse) {
//          
// },
//      
// onClose () {
//          
// },
//      
// sendMessage(msg) {
// this.ws.send(JSON.stringify(msg));
// },
//      
// openSocket() {
// this.ws = new WebSocket("ws://${contextPath}/sock/chat");
// this.ws.onopen = ()=>this.onOpenSock();
// this.ws.onmessage = (e)=>this.onMessage(JSON.parse(e.data));
// this.ws.onclose = ()=>this.onClose();
//           
// }
// };
//
// window.addEventListener ("load", e=>chatUnit.init());
