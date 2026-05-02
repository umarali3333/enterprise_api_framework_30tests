
package utils;

import io.restassured.RestAssured;

/* Base API configuration */
public class BaseAPI {

public static void setup(){
RestAssured.baseURI="https://jsonplaceholder.typicode.com";
}

}
