
Feature: PUT API Tests

Scenario: Update post
Given user sets API base URL
When user sends PUT request to "/posts/1"
Then validate status code is 200
And validate response contains "Updated Title"

Scenario: Update again
Given user sets API base URL
When user sends PUT request to "/posts/1"
Then validate status code is 200
