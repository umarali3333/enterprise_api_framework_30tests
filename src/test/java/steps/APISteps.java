package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import utils.BaseAPI;

public class APISteps {

    Response response;
  

    @Given("user sets API base URL")
    public void setupAPI() {
        BaseAPI.setup();
        //LoggerUtil.logger.info("Base URL configured");
    }

    @When("user sends GET request to {string}")
    public void sendGET(String endpoint) {
        response = given()
                //.log().all()   // removed to avoid printing request details
                .when()
                .get(endpoint);
    }

    @When("user sends POST request to {string}")
    public void sendPOST(String endpoint) {

        String payload = "{\"title\":\"Automation Test\",\"body\":\"BDD Framework\",\"userId\":22}";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                //.log().all()   // removed
                .when()
                .post(endpoint);
    }

    @When("user sends PUT request to {string}")
    public void sendPUT(String endpoint) {

        String payload = "{\"id\":1,\"title\":\"Umar Title\",\"body\":\"Updated Body\",\"userId\":22}";

        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                //.log().all()   // removed
                .when()
                .put(endpoint);
    }

    @When("user sends DELETE request to {string}")
    public void sendDELETE(String endpoint) {
        response = given()
                //.log().all()   // removed
                .when()
                .delete(endpoint);
    }

    @Then("validate status code is {int}")
    public void validateStatus(int code) {
        assertEquals(response.getStatusCode(), code);
    }

    @Then("validate response contains {string}")
    public void validateBody(String text) {
        assertTrue(response.getBody().asString().contains(text));
    }

    @Then("validate header {string}")
    public void validateHeader(String header) {
        assertNotNull(response.getHeader(header));
    }

    @Then("validate response time less than {int}")
    public void validateResponseTime(int time) {
        assertTrue(response.getTime() < time);
    }
}