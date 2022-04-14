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


var apiURL = 'http://localhost:8080/fetchreim';


function viewAll() {
	const element = document.getElementById('alert');
	element.remove();
    var createPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>View All Of My Reimbursements</h3></div>' + '<div id="tablecontainer"> hello i\'m a div box ' +
    '<table>' +
 ' <thead>'+
    '<tr>' +
      `<th>ID</th> <th>EMP ID</th> <th>MANID</th> <th>TYPE</th> <th>AMOUNT</th> <th>DESC</th> <th>TIME SUBMITTED</th> <th>TIME RESOLVED</th> <th>RESOLVED</th> <th>ACCEPTED</th>`+
    '</tr>' +
 ' </thead>' +
  '<tbody>' +
 ' </tbody>' +
 ' <tfoot>' +
' </tfoot>' +
'</table>' + 
    '</div>';
    document.getElementById("text").innerHTML = createPageBlock;
    getEmpReimbursements();
    
}

function getEmpReimbursements (){
    fetch(apiURL)
    .then(response => response.json())  // convert to json
    .then(json => displayData(json))    //pass data to displayData() OR print data to console
    .catch(err => console.log('Request Failed', err)); // Catch errors
}

function displayData(response) {
var len = response.length;
var table = document.getElementsByTagName('tbody');

for (var i=0; i < len; i++) {
    var tr = document.createElement('tr');
    var s = response[i];

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

    table.appendChild(tr);
}
}