# User Test

# As a system admin I want to be able to create users So that I can provide access to users of the system

## Create User

### Scenario 1 - Create user with valid inputs
-------------------------------------------------
Given I need to create an user
When I enter valid inputs in required fields - "Name" & "Email"
And Submit
Then the user should be created successfully
And success message should be shown

#### Example
If I enter "<mark> [John Doe](- "#userName") </mark>" & "<mark> [johndoe@gmail.com](- "#email") </mark>" then the user should be [created](- "#result = createUser(#userName, #email)") and display [User created successfully](- "?=#result")


###Scenario 2 - Create user with invalid inputs
---------------------------------------------------
Given I need to create an user
When I enter invalid inputs in required field "Name" & "Email"
And Submit
Then the user should not be created successfully
Adn an error must be displayed


#### Example
If I enter "<mark> [  ](- "#userName") </mark>" & "<mark> [  ](- "#email") </mark>" then the user should not be [created](- "#result = createUser(#userName, #email)") and display [Invalid Inputs](- "?=#result") <br />
If I enter <mark> [John Doe](- "#userName") </mark> & <mark> [john.com](- "#email") </mark> then the user should not be [created](- "#result = createUser(#userName, #email)") and display [Invalid Email](- "?=#result")



## Delete User
-------------------------------------------------------------------------------------------------
As a system admin
I want to be able to delete users
So that I can provide remove access to users in the system

### Scenario 1 - Delete user
-----------------------------------------------------
Given I need to delete an user
When I delete the user from the system
Then the user should be created successfully
And a success message should be displayed

#### Example
If I delete "<mark> [John Doe](- "#userName") </mark>" then the user should be [deleted](- "#result = deleteUser(#userName)") and display [User deleted successfully](- "?=#result")


## Edit user
--------------------------------------------------------------------------------------------------
As a system admin
I want to be able to update users
So that I can update their details in the system

### Scenario 1 - Update User details with valid inputs
--------------------------------------------------------
Given I need to update an user
When I enter valid inputs in required fields - "Name" & "Email"
And Submit
Then the user should be updated successfully
And success message should be shown

#### Example
If I update "<mark> John Doe </mark>" & "<mark> johndoe@email.com </mark>" to "<mark> [Jane Doe](- "#userName") </mark>" & "<mark> [janedoe@email.com](- "#email") </mark>" then the user should be [updated](- "#result = updateUser(#userName, #email)") to "<mark> Jane Doe </mark>" & "<mark> janedoe@email.com </mark>" and display [User updated successfully](- "?=#result")

### Scenario 2 - Create user with invalid inputs
----------------------------------------------------------------
Given I need to update an user
When I enter invalid inputs in required field "Name" & "Email"
And Submit
Then the user should not be updated successfully
Adn an error must be displayed

#### Example
If I update "<mark> John Doe </mark>" & "<mark> johndoe@email.com </mark>" to "<mark> [   ](- "#userName") </mark>" & "<mark> [   ](- "#email") </mark>" then the user should not be [updated](- "#result = updateUser(#userName, #email)") and display [Invalid Inputs](- "?=#result") <br />
If I update "<mark> John Doe </mark>" & "<mark> johndoe@email.com </mark>" to <mark> [John Doe](- "#userName") </mark> & <mark> [john.com](- "#email") </mark> then the user should not be [updated](- "#result = updateUser(#userName, #email)") and display [Invalid Email](- "?=#result")