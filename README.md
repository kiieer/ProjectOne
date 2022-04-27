<img src="https://i.imgur.com/fqvNC8M.png">

# Project One: Solana

## Project Description
This is my Project One For Revature, affectionately called Solana. It is an expense reimbursement system that allows employees to create reimbursement requests for the respective managers to approve or deny.

Please note that Solana is not a genuine company and that the art assets present on my website fall under Canva's Free Media License Agreement. My rights to the sunshine icon is non-exclusive.

## Technologies Used
- **Java**, *version 1.8*
- **Selenium**, *version 4.1.1*
- **JUnit**, *version 5.8.1*
- **Mockito**, *version 3.6.28*
- **Cucumber**, *version 7.2.3*
- **Javalin**, *version 4.1.1*
- **SQL**, *Postgres version 42.3.1*
- **Apache Maven**, *version 3.8.4*
- **HTML / JavaScript / CSS**
- **JDBC**

## Characteristics
This section represents the list of features that are currently present as well as the features I plan to implement in future development.

### Features
 - An employee can login with their correct company-assigned incredentials.
 - An employee can review all of their current and previously submitted reimbursements.
 - An employee can submit a brand new reimbursement.
 - A manager can login with their correct company-assigned incredentials.
 - A manager can preview *every* current and previously submitted reimbursements.
 - A manager can click on a respective reimbursement from the list to preview a management page.
 - A manager can approve or deny the reimbursement they are previewing.
 - A manager can edit the previous decision on a resolved reimbursement.
 
 ### To-do List
 - An employee can register with their own respective username and password to be in a 'pending' state in the database.
 - A manager can see all of the pending registrations and can approve or deny their access.
 - A manager can restrict active employees to return them to the pending status.
 - A manager can access a statistics page which includes the mean expenditure cost.
 - An employee can also upload documents when submitting a request.

## Getting Started With Solana

### Cloning My Repository
- Open up GitBash and change to the current working directory you would like to clone Solana.
- Input `$ git clone https://github.com/kiieer/ProjectOne.git` and press enter to create a clone.

### Database Set-up and Manipulation
- Under `ProjectOne/ProjectOne/src/main/resources/misc/` there is a file known as `data.sql`. Running this code, you should be able to create the respective database that is used in Solana. We are using Postgres.
- There are two insert commands within `data.sql` that you can use to generate an employee and manager, you can optionally alter these statements or keep these preset users.
- Under `ProjectOne/ProjectOne/src/main/java/com/revature/project/one/utils/` there is a class called `ConnUtil.java`. There is a variable on `line 10`, `PROJ_ONE`, that you should change to fit your database needs. [A useful tutorial of how to do this on JavaCodeGeeks.com.](https://examples.javacodegeeks.com/core-java/sql/java-jdbc-postgresql-connection-example/)

### Running Javalin and Accessing Solana
- 
