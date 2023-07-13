package wk16_TestAPI.studentinfo;

import org.junit.Test;
import wk16_TestAPI.model.StudentPojo;
import wk16_TestAPI.testbase.TestBaseStudentApp;

import static io.restassured.RestAssured.given;

public class PatchTestStudent extends TestBaseStudentApp {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo SP = new StudentPojo();
        SP.setEmail("rudshi@yahoo.com");
        SP.setProgramme("Automation Testing");

        given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",101)
                .body(SP)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(200);

    }


}
