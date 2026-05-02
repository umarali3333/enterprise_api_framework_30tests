
Feature: GET API Tests

Scenario: Get all posts
Given user sets API base URL
When user sends GET request to "/posts"
Then validate status code is 200
And validate response contains "title"

Scenario: Get post id 1
Given user sets API base URL
When user sends GET request to "/posts/1"
Then validate status code is 200
And validate response contains "userId"

Scenario: Validate response header
Given user sets API base URL
When user sends GET request to "/posts"
Then validate header "Content-Type"

Scenario: Validate response time
Given user sets API base URL
When user sends GET request to "/posts"
Then validate response time less than 5000

Scenario: Invalid post id
Given user sets API base URL
When user sends GET request to "/posts/9999"
Then validate status code is 404
