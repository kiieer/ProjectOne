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