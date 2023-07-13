package wk16_TestAPI.studentinfo;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.model.StudentPojo;
import wk16_TestAPI.testbase.TestBaseStudentApp;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PutTestStudent extends TestBaseStudentApp {

    static ValidatableResponse response;

    @Test
    public void updateStudentWithPut() {
        ArrayList<String>courses = new ArrayList<String>();
        courses.add("GitHub");
        courses.add("TestNG");

        StudentPojo SP = new StudentPojo();
        SP.setFirstName("Rud");
        SP.setLastName("Shiv");
        SP.setEmail("rudrashivaay@gmail.com");
        SP.setProgramme("Soft Test");
        SP.setCourses(courses);

        given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",101)
                .body(SP)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }
}
