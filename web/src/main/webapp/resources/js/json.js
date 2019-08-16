function sendRequest() {
	let value = 'some test value';
	console.log(value);

	let pElement = document.createElement('p');
	pElement.innerHTML = value;

	let contentDiv = document.getElementById('content');
	contentDiv.appendChild(pElement);

}