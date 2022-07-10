Feature: LoginPage Feature
Background:
Given User launches the loginpage
#@ignore
@Smoke
Scenario Outline: Login details
When User enters "<username>" and "<password>"
When User clicks on login button
Then User should land on "HomePage"

Examples:
| username					| password			 		 |
|varsha@tekarch.com	| NewPassword@Sales1 |