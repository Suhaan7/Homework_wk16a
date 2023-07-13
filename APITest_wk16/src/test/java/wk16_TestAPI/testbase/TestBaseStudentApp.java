package wk16_TestAPI.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBaseStudentApp {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath ="/student";

    }
}
