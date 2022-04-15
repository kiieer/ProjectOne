var url = "http://localhost:8080/"

async function makeNewReim(type, amt, desc) {
	let newExp = {type: type, amount: amt, desc: desc};
	
	console.log(newExp);
	
	let response = await fetch(url + 'makereim', {
		method: 'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify(newExp)});
		let result = await response.json();	
};

function newReim() {
	let type = document.getElementById("type").value;
	let amt = document.getElementById("amount").value;
	let desc = document.getElementById("description").value;
	//let empId = document.getElementById("userid").value;
	console.log("my values: " + type, amt, desc);
	makeNewReim(type, amt, desc);
};

function getEmpReimbursements (){
	console.log("im here");
    fetch('http://localhost:8080/fetchreim')
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function displayData(response) {
var len = response.length;
const table = document.getElementById("testtable");

for (var i=0; i < len; i++) {
    var tr = document.createElement('tr');
    var s = response[i];
    
    console.log("test");

    var td = document.createElement('td');
    td.innerHTML = s.id;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.empId;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.manId;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.type;
    tr.appendChild(td);

    td = document.createElement('td');
    td.innerHTML = s.amount;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.desc;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.submit;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.resolve;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.resolved;
    tr.appendChild(td);
    
    td = document.createElement('td');
    td.innerHTML = s.accepted;
    tr.appendChild(td);

    table.appendChild(tr);
}
}