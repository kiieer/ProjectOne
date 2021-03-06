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
    fetch('http://localhost:8080/fetchreim/emp/')
    .then(response => response.json())  // convert to json
    .then(json => displayEmpData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function displayEmpData(fetched) {
response = fetched.reverse();
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

function getAllReimbursements (){
	console.log("im here");
    fetch('http://localhost:8080/fetchreim')
    .then(response => response.json())  // convert to json
    .then(json => displayAllData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function displayAllData(fetched) {
response = fetched.reverse();
var len = response.length;
const table = document.getElementById("testtable");

for (var i= 0; i < len; i++) {
	
    var tr = document.createElement('tr');
    var s = response[i];
    
    for (let j in s) {
		if (s.hasOwnProperty(j)) {
			//console.log(`${j}: ${s[j]}`)
			if(s[j] == null) {
				s[j] = " ";
			}
		}
		}
		
    tr.innerHTML = `<td onclick=managereim(${s.id})> ${s.id}</td>
    <td onclick=managereim(${s.id})> ${s.empId}</td>
    <td onclick=managereim(${s.id})> ${s.manId}</td>
    <td onclick=managereim(${s.id})> ${s.type}</td>
    <td onclick=managereim(${s.id})> ${s.amount}</td>
    <td onclick=managereim(${s.id})> ${s.desc}</td>
    <td onclick=managereim(${s.id})> ${s.submit}</td>
    <td onclick=managereim(${s.id})> ${s.resolve}</td>
    <td onclick=managereim(${s.id})> ${s.resolved}</td>
    <td onclick=managereim(${s.id})> ${s.accepted}</td>`
    table.appendChild(tr);
}
}

async function manageReim(id, manboolean) {
	let manExp = {id: id, accepted: manboolean};
	
	console.log(manExp);
	
	let response = await fetch(url + 'resolve', {
		method: 'PUT',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify(manExp)});
		let result = await response.json();	
};

function manageReimData() {
	let id = document.getElementById("reimid").value;
	let manboolean = document.getElementById("booleanmanage").value;
	console.log("my values: " + id, manboolean);
	manageReim(id, manboolean);
};