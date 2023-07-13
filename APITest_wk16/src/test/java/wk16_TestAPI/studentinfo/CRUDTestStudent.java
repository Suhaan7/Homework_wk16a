package wk16_TestAPI.studentinfo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import wk16_TestAPI.model.StudentPojo;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CRUDTestStudent {

    static int studentID;
    static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void getAllStudentList() {
        given()
                .log().all()
                .when()
                .get("/list")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createStudent() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Painting");
        courses.add("Sculpture");

        StudentPojo SP = new StudentPojo();
        SP.setFirstName("Suhaan");
        SP.setLastName("Chaterjee");
        SP.setEmail("suhanchat7@gmail.com");
        SP.setProgramme("Artist");
        SP.setCourses(courses);

        Response response = (Response) given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(SP)
                .when()
                .post();

        HashMap<String,Integer>studentMap = given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path("findAll{it.firstName == 'Suhaan'}.get(0)");
        studentID = (int)studentMap.get("id");
        System.out.println(studentID);
     }

    @Test
    public void updateStudent() {
        StudentPojo SP = new StudentPojo();
        SP.setFirstName("Suhaan");
        SP.setLastName("Banerjee");
        SP.setEmail("suban7@gmail.com");
        SP.setProgramme("Curator");

        given()
                .header("Content-Type", "application/json")
                .pathParam("id", "101")
                .body(SP)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }
    @Test
    public void deleteStudent() {
        given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",101)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(204);
    }
}
