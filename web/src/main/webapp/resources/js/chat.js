let chatUnit = {
		init() {
			this.startbox = document.querySelector(".start");
			this.chatbox = document.querySelector(".chatbox");
			
			this.startbtn = this.startbox.querySelector("button");
			this.nameInput = this.startbox.querySelector("input");
			
			this.msgTextArea = this.chatbox.querySelector("textarea");
			
			this.bindEvents();
			
		},
		
		bindEvents() {
			this.startbtn.addEventListener("click", e=>this.openSocket())
			this.msgTextArea.addEventListener("keyup", e=> {
				if (e.ctrlKey && e.keyCode===13) {
					alert("test");
					e.preventDefault();
					this.send();
				}
			})
		},
		
		send() {
			this.sendMessage({
				name:this.name,
				text:this.msgTextArea.value
			});
		},
		
		onOpenSock () {
			
		},
		
		onMessage (parse) {
			
		},
		
		onClose () {
			
		},
		
		sendMessage(msg) {
			this.ws.send(JSON.stringify(msg));
		},
		
		openSocket() {
			this.ws = new WebSocket("ws://localhost:8081/sock/chat");
			this.ws.onopen = ()=>this.onOpenSock();
			this.ws.onmessage = (e)=>this.onMessage(JSON.parse(e.data));
			this.ws.onclose = ()=>this.onClose();
			
			this.name = this.nameInput.value;
			this.startbox.style.displey = "none";
			this.startbox.style.displey = "block";
		} 
};

window.addEventListener	("load", e=>chatUnit.init());