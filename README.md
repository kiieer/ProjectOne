# ProjectOne
Project One For Revature

https://trello.com/b/meiFuZ1a/project-one-solana

## Expense Reimbursement System
You are tasked with creating an expense reimbursement system. For a small company/group. This program will allow employees to create reimbursement requests.All Managers can view these requests and approve or deny them. When they approve/deny they can optionally leave a message.

## Key Feature
Key Features we are utilizing in our Expense Reimbursement System

## Employee
1. An employee can login to see their own reimbursements, past and pending
2. An employee can submit a reimbursement with an amount and a reason
3. Bonus allow for file upload

## Manager
1. A Manager can view all reimbursements past and pending
2. A Manager can appove or deny any reimbursement
3. Managers can view a 'statistics' page. That includes information like what employee spends the most money, mean expenditure cost etc...

## Key Notes
1. you do not have to allow for the creation of employees or managers.
2. You can have these already in the database.
3. You do not need to have implement security for application. You can assume that a later security team is responsible for making the applicaiton secure.
4. API routes do not need to be protected
5. Passwords do not have to be encrpted

## Technical and testing requirements
1. Backend developed in Javalin
2. Backend should be a RESTful web service
3. You may have to a make a non-REST compliant endpoint for login. This is normal.
4. AWS postgres RDS used to persist information
5. All DAO methods should have a test
6. All Service methods with logic should have a test
7. use mocking when applicable
8. There should be logging in the application
9. All user stories and acceptance criteria must be written out
10. completed E2E tests using gherkin and selnium for all user stories.

## ADDITIONAL
1. Your program should be a singleton.
2. Your program should have a logger.
3. Your program should implement Bootstrap CSS.
