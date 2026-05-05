
Feature: DELETE API Tests

Scenario: Delete post
Given user sets API base URL
When user sends DELETE request to "/posts/1"
Then validate status code is 200

Scenario: Delete another
Given user sets API base URL
When user sends DELETE request to "/posts/2"
Then validate status code is 404
