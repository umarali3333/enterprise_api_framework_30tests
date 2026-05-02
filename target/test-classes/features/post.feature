
Feature: POST API Tests

Scenario: Create post
Given user sets API base URL
When user sends POST request to "/posts"
Then validate status code is 201
And validate response contains "Automation Test"

Scenario: Create second post
Given user sets API base URL
When user sends POST request to "/posts"
Then validate status code is 201

Scenario: Validate response body after create
Given user sets API base URL
When user sends POST request to "/posts"
Then validate response contains "BDD Framework"
