package wk16_TestAPI.studentinfo;

import org.junit.Test;
import wk16_TestAPI.testbase.TestBaseStudentApp;

import static io.restassured.RestAssured.given;

public class DeleteTestStudent extends TestBaseStudentApp {

    @Test
    public void deleteStudent(){
        given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id","101")
                .when()
                .delete("/{id}")
                .then()
                .statusCode(204);

    }
}
