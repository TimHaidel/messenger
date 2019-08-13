let chatUnit = {
		init() {
			this.startbox = document.querySelector(".start");
			this.chatbox = document.querySelector(".chatbox");
			
			this.startbtn = this.startbox.querySelector("button");
			this.nameInput = this.startbox.querySelector("input");
			this.bindEvents();
			
		},
		
		bindEvents() {
			this.startbtn.addEventListener("click", e=>this.openSocket())
		},
		
		openSocket() {
			this.ws = new WebSocket("ws${contextPath}/sock/chat");
			this.name = this.nameInput.value;
			this.startbox.style.displey = "none";
			this.startbox.style.displey = "block";
		} 
};

window.addEventListener	("load", e=>chatUnit.init());