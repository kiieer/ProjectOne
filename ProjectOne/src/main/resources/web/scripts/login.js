var url = "http://localhost:8080/"

async function loginFunction(username, pass) {
	let username1 = { username: username, pass: pass};
	
	//spinny boy
	var element = document.querySelector('#alert');
    var copy = element.cloneNode(true);
	copy.className = 'alert alert-primary';
    copy.innerHTML = '<img src="images/canvaicon.png" width="7%" id="spin">';
   	element.replaceWith(copy);
	
	let response = await fetch(url + 'login', {
		method: 'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify(username1)});
		let result = await response.json();
		console.log(result.username);
		if (result.username === null) {
				//login failure
			    var element = document.querySelector('#alert');
			    var copy = element.cloneNode(true);
			    copy.id = 'alert';
			    copy.className = 'alert alert-danger';
			    copy.innerHTML = '<h3><i>Alert: login was unsuccessful. Try again.</i></h3>';
			    element.replaceWith(copy);
			    
			} else {
				if (result.type == "manager") {
				window.location.href="/rimbm.html";
			} else {
				window.location.href="/rimbe.html";
			}
			}
	}

function getInput() {
	let username = document.getElementById("user").value
	let pass = document.getElementById("password").value
	loginFunction(username, pass);
}

function loginpage() {
    var loginPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>Login Page</h3></div>' +
    '<p id="login"><label>Username: &nbsp; </label><br>' +
    '<input id = "user" type="text" placeholder="enter username..." name="username" required>' +
    '<label id="pass">Password: &nbsp;</label><br>' +
    '<input id = "password" type="password" placeholder="enter password..." name="username" required></p>' +
    '<button type="submit" onclick="getInput()" id="loginbtn">Login</button>';
    document.getElementById("text").innerHTML = loginPageBlock;
}

function logout() {
	sessionStorage.clear();
	window.location.href="http://localhost:8080/";
}