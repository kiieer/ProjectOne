function faq() {
    var faqBlock = '<div id="faq">' +
'<div class="alert alert-primary" role="alert" id="alert"><h5><b>Frequently Asked Questions</b></h5></div> ' +
'<p><h6><b>Q: I am an employee of Solana, how do I locate my login information or sign up?</b><br></h6>' +
'You are currently unable to create an account. <br> You would log in using the ID and password that you were provided upon being hired on.<br> If you cannot locate your information, please reach out to Human Resources and we\'ll help you out! <hr>' +
'<h6><b>Q: What should I have on hand when submitting a reimbursement request?</b><br></h6>' +
'Have any relevant paperwork such as receipts and documents handy regarding the reimbursement.<br> If lacking, it is likely we are unable to process your request. <hr>' +
'<h6><b>Q: I submitted my reimbursement request - when should I expect an answer?</b><br></h6>' +
'We check frequently but each reimbursement request is reviewed individually.<br> You should expect a response in 4-5 business days.' +
' </div>';
    document.getElementById("text").innerHTML = faqBlock;
}

function home() {
    var indexBlock = '<p><h4>Good morning, Sunshine!</h4>' +
'Welcome to our expense reimbursement system for any and all Solana™ needs! <br>' +
'Please log in with your company assigned username and password to begin the reimbursement process.<br>' +
'Your mileage may vary: wait times for a response can take up to <u>five business days</u>. Please be patient!<br>' +
'<div class="alert alert-primary" role="alert" id="alert"><b>If you are unable to login successfully, please submit a ticket to Human Resources and we\'ll get it sorted out.</b><br> ' +
'Additionally, if you have any questions do not hesitate to check out our <a onclick="faq()" class="link-primary">Frequently Asked Questions!</a></div> ' +
' </p>';
    document.getElementById("text").innerHTML = indexBlock;
}

function login() {
    var loginBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>loading...</h3></div><img src="images/canvaicon.png" width="15%" id="spin">';
    document.getElementById("text").innerHTML = loginBlock;
    setTimeout(loginpage, 500);
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

function createreim() {
	const element = document.getElementById('alert');
	element.remove();
    var createPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>Create Reimbursement</h3></div>' +
    '<form onsubmit="newReim()">&nbsp <p id="test"><label>Type: &nbsp; </label><br>' +
    '<input id="type" class = "create" type="text" placeholder="enter type..." name="type" required>' +
    '<label class="bottom">Amount: &nbsp;</label><br>' +
    '<input id="amount" class = "create" type="number" placeholder="enter amount..." name="amount" required>' +
     '<label class="bottom">Reimbursement Description: &nbsp;</label><br>' +
    '<input id="description" class = "create" type="textbox" placeholder="enter description..." name="description" required></p>' +
    '<button type="submit" id="loginbtn">Submit</button></form>';
    console.log("test");
    document.getElementById("text").innerHTML = createPageBlock;
}

function viewMyReim() {
	const element = document.getElementById('alert');
	element.remove();
    var createPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>View All Of My Reimbursements</h3></div>' + '<div id="tablecontainer">' +
    '<table id="testtable">' +
 ' <thead>'+
    '<tr>' +
      `<th>ID</th> <th>Employee</th> <th>Manager</th> <th>Type</th> <th>Amount</th> <th>Description</th> <th id="makesmall">Submitted</th> <th>Settled</th> <th>Resolved</th> <th>Accepted</th>`+
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

function viewAll() {
	const element = document.getElementById('alert');
	element.remove();
    var createPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>View All Employee Reimbursements</h3></div>' + '<div id="tablecontainer">' +
    '<table id="testtable">' +
 ' <thead>'+
    '<tr>' +
      `<th>ID</th> <th>Employee</th> <th>Manager</th> <th>Type</th> <th>Amount</th> <th>Description</th> <th id="makesmall">Submitted</th> <th>Settled</th> <th>Resolved</th> <th>Accepted</th>`+
    '</tr>' +
 ' </thead>' +
  '<tbody>' +
 ' </tbody>' +
 ' <tfoot>' +
' </tfoot>' +
'</table>' + 
    '</div>';
    document.getElementById("text").innerHTML = createPageBlock;
   getAllReimbursements();
    
}

function managereim(id) {
	const element = document.getElementById('alert');
	element.remove();
    var createPageBlock = '<div class="alert alert-primary" role="alert" id="alert"><h3>Manage Reimbursement</h3></div>' +
    '<form onsubmit="manageReimData()">&nbsp <p id="test"><label>ID: &nbsp; </label><br>' +
    `<input id="reimid" class = "create" type="text" placeholder="enter reimbursement id..." name="reimid" disabled value="${id}">` +
	  '<label class="bottom">Manage: &nbsp; </label><br>' +
	  '<select id="booleanmanage">' +
	    '<option value="true">accept</option>' +
	    '<option value="false">reject</option>' +
	 ' </select></p>' +
    '<button type="submit" id="loginbtn">Submit</button></form>';
    console.log("test");
    document.getElementById("text").innerHTML = createPageBlock;
}


