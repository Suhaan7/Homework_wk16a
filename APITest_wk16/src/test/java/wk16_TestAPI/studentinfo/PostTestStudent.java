package wk16_TestAPI.studentinfo;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import wk16_TestAPI.model.StudentPojo;
import wk16_TestAPI.testbase.TestBaseStudentApp;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PostTestStudent extends TestBaseStudentApp {

    static ValidatableResponse response;

    @Test
    public void createStudent(){
        ArrayList<String>courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("Selenium");
        courses.add("Postman");

        StudentPojo SP = new StudentPojo();
        SP.setFirstName("Rudra");
        SP.setLastName("Shivaay");
        SP.setEmail("rudrashivaay312@gmail.com");
        SP.setProgramme("Software Testing");
        SP.setCourses(courses);

        given()
                .header("Content-Type","application/json")
                .body(SP)
                .when()
                .post()
                .then()
                .statusCode(201);


    }
}
