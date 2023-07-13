package wk16_TestAPI.studentinfo;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.testbase.TestBaseStudentApp;

import static io.restassured.RestAssured.given;

public class GetTestStudent extends TestBaseStudentApp {

    static ValidatableResponse response;

    @Test
    public void getAllStudentsInfo() {
        response = given()
                .when()
                .get("/list")
                .then();
        response.statusCode(200);
    }
    @Test
    public void getSingleStudentInfo(){
        response=given()
                .pathParam("id",101)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);
    }

    @Test
    public void getStudentWithParameter(){
        response=given()
                .queryParam("programme","Law")
                .queryParam("limit","5")
                .when()
                .get("/list")
                .then()
                .log().all();
        response.statusCode(200);
    }
}
