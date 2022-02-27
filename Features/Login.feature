Feature: Login

Scenario: Successfull login with valid credentials 
Given User launch chrome browser
When user open URL "http://admin-demo.nopcommerce.com/login"
And User enter Email as "admin@yourstore.com" and Password as "admin"
And Clicks on login
Then Page title should be "Dashboard / nopCommerce administration"
When User clicks on log out link
Then Page title should be "Your store. Login"
And Close browser 