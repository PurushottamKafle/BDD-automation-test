Feature: Login into account
   Existing users must be able to login to their stackoverflow account via correct credentials

Scenario: Login to user using correct credentials
   Given User navigates to stackoverflow website
   And User clicks on the login button on the webpage
   And User enters a valid username
   And User enters a valid password
   When User clicks on login button
   Then User must be redirected to successful login page
   
   